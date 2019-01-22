package com.debyendu.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table (name = "employee")
public class Employee {

   @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "eid")
   private String eid;
   @Column(name = "ename")
   private String ename;
   @Column(name = "salary")
   private String salary;
   @Column(name = "deg")
   private String deg;

   public Employee(String eid, String ename, String salary, String deg) {
      super( );
      this.eid = eid;
      this.ename = ename;
      this.salary = salary;
      this.deg = deg;
   }

   public Employee( ) {
      super();
   }

   public String getEid( ) {
      return eid;
   }

   public void setEid(String eid) {
      this.eid = eid;
   }

   public String getEname( ) {
      return ename;
   }

   public void setEname(String ename) {
      this.ename = ename;
   }

   public String getSalary( ) {
      return salary;
   }

   public void setSalary(String salary) {
      this.salary = salary;
   }

   public String getDeg( ) {
      return deg;
   }

   public void setDeg(String deg) {
      this.deg = deg;
   }

   @Override
   public String toString() {
      return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
   }
}
