import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            String sql ="INSERT INTO DMSV (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong,MaMH)" + " VALUES('A24',Nguyen','Van An','05-07-1994','Hà Nội','Vl',Null,'04)";
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(sql);

            if (rows >0) {
                System.out.println("row has been inserted.");
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