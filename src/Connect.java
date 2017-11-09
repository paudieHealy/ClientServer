/**
 * Created by paudie on 08/11/2017.
 */
public class Connect {

    private String USERNAME = "admin";
    private String PASSWORD = "12345";
    private int PORT = 9090;
    private String HOSTNAME = "localhost";

    public String getUSERNAME()
    {
        return this.USERNAME;
    }
    public String getPASSWORD()
    {
        return this.PASSWORD;
    }

    public int getPORT()
    {
        return this.PORT;
    }

    public String getHOSTNAME()
    {
        return this.HOSTNAME;
    }
}
