package tw.idv.ixercise.store.entity;

public class product {
		private Integer product_no;
		private Integer product_type_no;
		private String product_name;
		private Integer price;
		private Integer product_storage;
		private String description;
		private Integer total_comment;
		private double product_star;
		private String product_photo;
		
		
		public product() {}
		
		
		
		public product(Integer product_type_no, String product_name, Integer price, Integer product_storage,
				String description, Integer total_comment, double product_star, String product_photo) {
			super();
			this.product_type_no = product_type_no;
			this.product_name = product_name;
			this.price = price;
			this.product_storage = product_storage;
			this.description = description;
			this.total_comment = total_comment;
			this.product_star = product_star;
			this.product_photo = product_photo;
		}



		public Integer getProduct_no() {
			return product_no;
		}
		public void setProduct_no(Integer product_no) {
			this.product_no = product_no;
		}
		public Integer getProduct_type_no() {
			return product_type_no;
		}
		public void setProduct_type_no(Integer product_type_no) {
			this.product_type_no = product_type_no;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getProduct_storage() {
			return product_storage;
		}
		public void setProduct_storage(Integer product_storage) {
			this.product_storage = product_storage;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getTotal_comment() {
			return total_comment;
		}
		public void setTotal_comment(Integer total_comment) {
			this.total_comment = total_comment;
		}
		public double getProduct_star() {
			return product_star;
		}
		public void setProduct_star(double product_star) {
			this.product_star = product_star;
		}
		public String getProduct_photo() {
			return product_photo;
		}

		public void setProduct_photo(String product_photo) {
			this.product_photo = product_photo;
		}
		
}
