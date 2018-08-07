package org.cap.dao;

import java.sql.*;

import org.cap.exception.AccountNotFound;
import org.cap.model.Account;


public class AccountDaoImpl implements IAccountDao {
	 private  Connection connect;
	 private Statement statement;
	 
		public boolean addAccount(Account account) {
			String sql="insert into Account values(?,?,?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 connect = DriverManager
	                    .getConnection("jdbc:mysql://localhost:3306/capaccount","root","India123");
				 PreparedStatement stat=connect.prepareStatement(sql);
				 stat.setInt(1, account.getAccountNo());
				 stat.setDouble(2, account.getOpeningBalance());
				 stat.setString(3, account.getCustomer().getFirstName());
				 int count=stat.executeUpdate();
				 if(count>0)
					 return true;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}

		@Override
		public Account findAccount(int accountNo) {
			
			return null;
		}

		@Override
		public Account withdraw(int accountNo, double amount_withdraw) {
			
			return null;
		}

		

		@Override
		public Account updateBalance(int accountNo, double amount) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Account deposit(int accountNo, double amount_withdraw) throws AccountNotFound {
			// TODO Auto-generated method stub
			return null;
		}

	}




/*public class AccountDaoImpl implements IAccountDao{

	private Connection getConnection() {
		Connection connect=null;
		try {
			
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/capaccount","root","India123");
            
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return connect;
	}
	@Override
	public boolean addAccount(Account account) {
		
		String sql="insert into account values(?,?,?)";
		try {
			PreparedStatement stmt=getConnection().prepareStatement(sql);
			stmt.setInt(1, account.getAccountNo());
			stmt.setDouble(2, account.getOpeningBalance());
			stmt.setString(3, account.getCustomer().getFirstName());
			int count=stmt.executeUpdate();
			if(count>0)
				 return true;
			}  catch (SQLException e) {
           e.printStackTrace();
        } 
		return false;
	}

}*/

