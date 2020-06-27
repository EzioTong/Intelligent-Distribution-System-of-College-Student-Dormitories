package NetWork;

import java.sql.*;

/*
 * ����ʵ��JDBC�ķ�װ����Ҫʵ�ִ��������
 * ��������ĳ�����̣���Ա��������Ա��������
 * ���ݿ�ķ��ʲ��裺
 * ��1�������������������ӣ����������󣨷�װ�ڹ��췽���У�
 * ��2������insert��delete��update֮��Ĳ�����������Ӱ��ļ�¼����
 * ��>0�����ʾ�����ɹ��������ʾ����ʧ�ܣ���Ҫʵ��һ������
 * ��3������select�Ĳ��������ص��ǲ�ѯ���ļ�¼������Ҫʵ��һ������
 * ��4�������ݿ����Ӷ���Ĺرգ����ͷ���Դ�������Դ����ʱ���ͷţ�ϵͳ�������
 * ��out of memory���Ĵ��󣬵���ϵͳ����
 *
 */
public class DBManager {
    //��Ա�ĳ�Ա����
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private String dirverName;
    private String url;
    private String username;
    private String password;

    //����Ϊ��װ�ĳ�Ա����
    /*
     * 1.���췽����ʵ�ּ����������������ӣ�����������
     */
    public DBManager(){
            dirverName="com.mysql.jdbc.Driver";
            url="jdbc:mysql://103.213.245.111/rarcher";
            username = "rarcher";
            password = "rarcher";
        try {
            Class.forName(dirverName);
            con = DriverManager.getConnection(url, username, password);
            if (!con.isClosed())
                System.out.println("Successfully connected ");
            else
                System.out.println("failed connected");
            //3.����������
            stm = con.createStatement();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /*
     * 2.����insert��delete��update֮��Ĳ���,�����쳣�ĳ��������Բ�ȡ���ַ�ʽ
     * ��1��ʹ��try��catch
     * ��2)ֱ���׳���ʹ��thows�������������߽��д���
     */
    public boolean executeUpdate(String sql) throws SQLException {
        boolean ret=false;
        int i=stm.executeUpdate(sql);
        if(i>0){
            ret=true;
        }
        return ret;
    }

    /*
     * 3.����select�Ĳ���
     */
    public ResultSet executeQuery(String sql) throws SQLException{
        rs=stm.executeQuery(sql);
        return rs;
    }
    /*
     * 4.��Դ���ͷ�
     */
    public void close(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
