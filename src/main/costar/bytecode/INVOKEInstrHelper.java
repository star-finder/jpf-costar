package costar.bytecode;

public class INVOKEInstrHelper {
	
	public static boolean isPrimitiveType(String typeName) {
		if (typeName.equals("byte") || typeName.equals("char") || typeName.equals("double") ||
			typeName.equals("float") || typeName.equals("int") || typeName.equals("long") || 
			typeName.equals("short") || typeName.equals("boolean")) {
			return true;
		} else {
			return false;
		}
	}

}
