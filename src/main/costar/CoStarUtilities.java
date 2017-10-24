package costar;

public class CoStarUtilities {
	
	public static String toS2SATType(String type) {
		if (type.contains("."))
			type = type.replaceAll("\\.", "_");
		
		if (type.contains("$"))
			type = type.replaceAll("$", "__");
		
		return type;
	}
	
	public static String toJavaType(String type) {
		if (type.contains("__"))
			type = type.replaceAll("__", "$$");
		
		if (type.contains("_"))
			type = type.replaceAll("_", ".");
		
		return type;
	}
	
	public static void main(String[] args) {
		System.out.println(toS2SATType("features.sll.Node"));
		System.out.println(toJavaType("features_sll_Node"));
	}

}
