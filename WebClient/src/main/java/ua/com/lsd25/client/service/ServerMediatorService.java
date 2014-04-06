package ua.com.lsd25.client.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.com.lsd25.common.entity.Book;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This sercies is used for send JSON request oit the server
 *
 * @author Victor Zagnitko on 02.04.2014.
 */
@Service
public class ServerMediatorService {

    private static final Logger LOG = LoggerFactory.getLogger(ServerMediatorService.class);

    private static final int OK = 200;

    private static final String ENTITY = "entity";

    @Autowired
    @Qualifier(value = "mapper")
    private ObjectMapper mMapper;

    @Value("${server.host}")
    private String mHost;

    @Value("${server.port}")
    private String mPort;

    /**
     *
     */
    public ServerMediatorService() {
        super();
    }

    /**
     * Check server connection
     */
    @PostConstruct
    public void checkServerConnection() throws IOException, URISyntaxException {
        LOG.info("Start check server connection");
        HttpUriRequest httpUriRequest = new HttpPost(new URI(getTestUrl()));
        HttpResponse response = null;
        try {
            response = getHttpResponse(httpUriRequest);
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        if (response == null || response.getStatusLine().getStatusCode() != OK) {
            throw new RuntimeException("Cannot connect to the server");
        } else {
            LOG.info("Success connect to the server");
        }
    }

    /**
     * Get list entites
     *
     * @param httpUriRequest request object
     * @return
     * @throws Exception if operation has error
     */
    public List<Book> getListEntities(HttpUriRequest httpUriRequest) throws Exception {
        Map<String, ?> bookResponse = getJsonThroughRest(httpUriRequest);
        return this.mMapper.convertValue(bookResponse.get(ENTITY), List.class);
    }

    /**
     * Received entity from the server
     *
     * @param entityClazz    to mapper object
     * @param httpUriRequest request object
     * @param <T>            parameter entity that will be received from the server
     * @return found entity or null
     * @throws Exception if has
     */
    public <T> T getEntity(Class<T> entityClazz, HttpUriRequest httpUriRequest) throws Exception {
        Map<String, ?> bookResponse = getJsonThroughRest(httpUriRequest);
        return this.mMapper.convertValue(bookResponse.get(ENTITY), entityClazz);
    }

    /**
     * Remove entity from the database
     *
     * @param httpUriRequest
     * @return status operation
     * @throws Exception if operation has error
     */
    public Map<String, ?> sendJsonRequestWithBody(HttpUriRequest httpUriRequest) throws Exception {
        return getJsonThroughRest(httpUriRequest);
    }

    /**
     * Create url to connect to the server
     *
     * @param uri to connect
     * @return created url to connect to the server
     */
    public String getUrl(String uri) {
        StringBuilder sb = new StringBuilder("http://");
        sb.append(this.mHost);
        sb.append(":");
        sb.append(this.mPort);
        sb.append("/rest/book/");
        sb.append(uri);
        return sb.toString();
    }

    /**
     * @param httpUriRequest request object
     * @return received JSON from the server
     * @throws Exception if operation has error
     */
    private Map<String, ?> getJsonThroughRest(HttpUriRequest httpUriRequest) throws Exception {
        String json = getJson(httpUriRequest);
        return this.mMapper.readValue(json, new TypeReference<LinkedHashMap<String, ?>>() {
        });
    }

    /**
     * Get JSON from the server
     *
     * @param httpUriRequest request object
     * @return received json from the server
     * @throws Exception if operation has error
     */
    private String getJson(HttpUriRequest httpUriRequest) throws Exception {
        HttpResponse response = getHttpResponse(httpUriRequest);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            LOG.info("Output from Server ....");
            String line = "";
            while ((line = br.readLine()) != null) {
                LOG.info(line);
                sb.append(line);
            }
        } finally {
            HttpClientBuilder.create().build().getConnectionManager().shutdown();
        }
        return sb.toString();
    }

    /**
     * Get http response from server
     *
     * @param httpUriRequest request object
     * @return object ofr http response
     * @throws IOException if operation has error
     */
    private HttpResponse getHttpResponse(HttpUriRequest httpUriRequest) throws IOException {
        httpUriRequest.addHeader("accept", "application/json");
        httpUriRequest.setHeader("Content-Type", "application/json");
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute(httpUriRequest);
    }

    /**
     * Create url for test server
     *
     * @return created string to test server
     */
    private String getTestUrl() {
        StringBuilder sb = new StringBuilder("http://");
        sb.append(this.mHost);
        sb.append(":");
        sb.append(this.mPort);
        sb.append("/rest/test/server");
        return sb.toString();
    }

}
