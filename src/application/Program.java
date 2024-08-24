package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wyane");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 7: department insert ===");
		Department newDep = new Department(null, "bow");
		departmentDao.insert(newDep);
		System.out.println("Inserted!");
		
		System.out.println("\n=== TEST 8: department update ===");
		newDep = departmentDao.findById(2);
		
		System.out.println("\n=== TEST 9: department findById ===");
		Department depart = departmentDao.findById(4);
		System.out.println(depart);
		
		System.out.println("\n=== TEST 10: department findAll ===");
		List<Department> listDep = departmentDao.findAll();
		for(Department obj : listDep) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
