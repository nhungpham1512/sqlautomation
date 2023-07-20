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
//Cach 1:
//            String sql ="INSERT INTO DMSV (MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong,MaMH)" + " VALUES('A25','Nguyen','Khanh Vy','Nam','05-05-1995','Hà Nội','Vl',Null,'04')";
//            Statement statement = conn.createStatement();
//            int rows = statement.executeUpdate(sql);
//Cach 2:
            String sql ="INSERT INTO DMSV (MaSV,HoSV,TenSV,Phai,NgaySinh,MaMH)" + " VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"A28");
            statement.setString(2,"Pham");
            statement.setString(3,"Nhung");
            statement.setString(4,"Nu");
            statement.setString(5,"12-10-1996");
            statement.setString(6,"04");
            int rows = statement.executeUpdate();
            
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