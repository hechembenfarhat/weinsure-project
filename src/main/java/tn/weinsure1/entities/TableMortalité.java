package tn.weinsure1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_mortalite")
public class TableMortalité  implements Serializable{
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="IdTable")
		private Long idTable ;
		

	@Column(name="x")
		private int x;
		
		@Column(name="TD99")
		private float Td_99;

		@Column(name="TV99")
		private float Tv_99;

		
		@Column(name="proba")
		private float proba;

		public float getProba() {
			return proba;
		}

		public void setProba(float proba) {
			this.proba = proba;
		}


		public TableMortalité(  float td_99, float tv_99, int x, float proba ) {
			super();
			Td_99 = td_99;
			Tv_99 = tv_99;
			this.x = x;
			this.proba = proba;
		}

		public TableMortalité() {
			super();
		}

		
	
		public Long getIdTable() {
			return idTable;
		}

		public void setIdTable(Long idTable) {
			this.idTable = idTable;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public float getTd_99() {
			return Td_99;
		}

		public void setTd_99(float td_99) {
			Td_99 = td_99;
		}

		public float getTv_99() {
			return Tv_99;
		}

		public void setTv_99(float tv_99) {
			Tv_99 = tv_99;
		}

		public TableMortalité(int x, float td_99, float tv_99) {
			this.x = x;
			Td_99 = td_99;
			Tv_99 = tv_99;
		}

		
		
}

