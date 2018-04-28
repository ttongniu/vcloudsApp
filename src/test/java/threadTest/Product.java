package threadTest;

public class Product {
        private  String name;//产品名

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Product [name=" + name + "]";
		}

		public Product(String name) {
			super();
			this.name = name;
		}

		public Product() {
			super();
		}
        
		
}
