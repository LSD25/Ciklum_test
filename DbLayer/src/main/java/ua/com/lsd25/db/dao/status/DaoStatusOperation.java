package ua.com.lsd25.db.dao.status;

/**
 * This Class contains general statuses, that returned from the Doa Class
 *
 * @author Victor Zagnitko on 05.04.2014.
 */
public final class DaoStatusOperation {

    public static final String SUCCESS_UPDATE_ENTITY = "Success updated record in database";

    public static final String FAIL_UPDATE_ENTITY = "Record cannot be updated in databaes";

    public static final String SUCCESS_DELETE_ENTITY = "Success deleted record in database";

    public static final String FAIL_DELETE_ENTITY = "Record cannot be deleted from the database";

    public static final String SUCCESS_ADDED_NEW_ENTITY = "Success added new record in database";

    public static final String FAIL_ADDED_NEW_ENTITY = "Fail added new record in database";

    public static final String FAIL_FOUND_ENTITY = "Record not found in database";

    /**
     *
     */
    public DaoStatusOperation() {
        super();
    }

}
