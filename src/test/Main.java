package test;

public class Main {

	public static void main(String[] args) {
		StudentDao studentDao = StudentDao.getInstance();
		studentDao.dbConnect();
		studentDao.connectTest();
		studentDao.connectionClose();
	}
}
