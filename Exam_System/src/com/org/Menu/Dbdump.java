package com.org.Menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Dbdump implements ALLinterface{

	@Override
	public real getinfobypro_no(String NO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean check(String no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int Insert(String pro_no, String pro_detail, String pro_ansno,
			String pro_keyw, String pro_dif, String cha_no, String cha_title,
			String cha_mpoString, String pro_type,String ANS_NO,String ANS_DETAIL) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dataBaseDump(String port, String username, String password,
			String databasename, String sqlname) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:\\java\\dbDump\\");
        if ( !file.exists() ){
           file.mkdir();
        }
        File datafile = new File(file+File.separator+sqlname+".sql");
        /*if( datafile.exists() ){
            System.out.println(sqlname+"文件名已存在，请更换");
            return ;
        }*/
        //拼接cmd命令
//        String path="D:\\JAVA\\mysql-5.5.62-winx64\\bin\\";
//        System.out.println("开始备份："+databasename);
//        Runtime rt = Runtime.getRuntime();
      //  rt.exec("cmd /c "+path+"mysqldump -P3306 -u"+username+" -p"+password+" "+databasename+" > "+datafile.toString());
       // System.out.println("备份成功!");
        /*Process exec = Runtime.getRuntime().exec("cmd /c mysqldump -h"+port+" -u "+username+" -p"+password+" "+databasename+" > "+datafile);
        if( exec.waitFor() == 0){
            System.out.println("数据库备份成功,备份路径为："+datafile);
        }*/
       
        System.out.println("数据库备份成功,备份路径为："+datafile);
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd /c D:\\mysql-5.5.62-winx64\\bin\\mysqldump -hlocalhost -u"+username+" -p"+password+" --opt "+databasename+">"+datafile);
		System.out.println("Backup Time is " + new Date().toString());
		
	}

	@Override
	public void backup(String root, String pwd, String dbName, String filePath) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
        sb.append("mysql");
        sb.append(" -hlocalhost");
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" <");
        sb.append(filePath);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始还原数据");
        try {
            Process process = runtime.exec("cmd /c"+sb.toString());
            InputStream is = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is,"utf8"));
            String line = null;
            while ((line=bf.readLine())!=null){
                System.out.println(line);
            }
            is.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateinfo1(real INFO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateinfo2(real INFO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void searchdelete(String no) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getnumbypro_state() {
		// TODO Auto-generated method stub
		return null;
	}
}
