package ua.com.lsd25.client.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public List<Book> getBooks(HttpUriRequest httpUriRequest) throws Exception {
        return getEntity(List.class, httpUriRequest);
    }

    public Book getBook(HttpUriRequest httpUriRequest) throws Exception {
        return getEntity(Book.class, httpUriRequest);
    }

    public Boolean deleteBook(HttpUriRequest httpUriRequest) throws Exception {
        return getEntity(Boolean.class, httpUriRequest);
    }

    public String getUrl(String uri) {
        StringBuilder sb = new StringBuilder("http://");
        sb.append(this.mHost);
        sb.append(":");
        sb.append(this.mPort);
        sb.append("/rest/book/");
        sb.append(uri);
        return sb.toString();
    }

    private <T> T getEntity(Class<T> clazz, HttpUriRequest httpUriRequest) throws Exception {
        String json = getJson(httpUriRequest);
        Map<String, ?> bookResponse = this.mMapper.readValue(json, new TypeReference<LinkedHashMap<String, ?>>() {
        });
        return this.mMapper.convertValue(bookResponse.get(ENTITY), clazz);
    }

    private String getJson(HttpUriRequest httpUriRequest) throws Exception {
        httpUriRequest.addHeader("accept", "application/json");
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(httpUriRequest);
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
            client.getConnectionManager().shutdown();
        }
        return sb.toString();
    }

}
