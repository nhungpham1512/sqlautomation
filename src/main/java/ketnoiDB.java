import java.sql.*;

public class ketnoiDB {
    private static Connection conn;
    public static void getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String user = "sa";
        String pass = "12345";

        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName= QLSV ;encrypt=true; trustServerCertificate=true", user, pass);
//Option 1:
            String sql ="INSERT INTO DMSV (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong,MaMH)" + " VALUES('A32','Pham','Tuan Tai','Nam','25-11-1999','Ha Noi','Vl',Null,'04')";
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(sql);

            if (rows >0) {
                System.out.println("row has been inserted.");
                System.out.println("the number of new rows = " + rows);
            }
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        if(conn == null){
            System.out.println("Ket noi that bai");
        }else{
            System.out.println("Ket noi thanh cong!!!");
        }
    }
    public static void main(String[] agrs){
        getConnection();

    }
}