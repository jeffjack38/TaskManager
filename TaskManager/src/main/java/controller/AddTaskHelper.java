package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Task;

public class AddTaskHelper {
	//create global instance of the EntityManagerFactory
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskManager");
	
	//method that will accept Task to add to the database
	public void insertItem(Task task) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(task);
		em.getTransaction().commit();
		em.close();
	}
	
	//method to create a list of all tasks and persist to database
	public List<Task> showAllTasks(){
		EntityManager em = emfactory.createEntityManager();
		List<Task> allTasks = em.createQuery("SELECT i FROM Task i").getResultList();
		return allTasks;
	}
	
	//method that will delete tasks from database
	public void deleteTask(Task toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery("select task from Task task where task.title = :selectedTitle and task.description = :selectedDescription and task.status = :selectedStatus and task.id = :selectedId", Task.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedStatus", toDelete.getStatus());
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//only get one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new Task
		Task result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Task searchForTaskById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Task found = em.find(Task.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateTask(Task toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Task> searchForTaskByTitle(String titleName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction();
		TypedQuery<Task> typedQuery = em.createQuery("select task from Task task where task.title = :selectedTitle", Task.class);
		typedQuery.setParameter("selectedTitle", titleName);
		
		List<Task> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}
	
	public List<Task> searchForTaskByDescription(String descriptionName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery("select task from Task task where task.description = :selectedDescription", Task.class);
		typedQuery.setParameter("selectedDescription", descriptionName);
		
		List<Task> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}
	
	public List<Task> searchForTaskByStatus(String statusName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery("select task from Task task where task.status = :selectedStatus", Task.class);
		typedQuery.setParameter("selectedStatus", statusName);
		
		List<Task> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	

}
