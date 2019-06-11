package it.contrader.dto;

public class IngredientDTO {
		private int idingredient;
		private String nome;
		public IngredientDTO() {
			super();
		}
		public IngredientDTO(String nome) {
			super();
			this.nome = nome;
		}
		public int getIdingredient() {
			return idingredient;
		}
		public void setIdingredient(int idingredient) {
			this.idingredient = idingredient;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
}
