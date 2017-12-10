/*
 * Copyright (C) 2015, United States Government, as represented by the 
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 * 
 * The PSYCO: A Predicate-based Symbolic Compositional Reasoning environment 
 * platform is licensed under the Apache License, Version 2.0 (the "License"); you 
 * may not use this file except in compliance with the License. You may obtain a 
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0. 
 * 
 * Unless required by applicable law or agreed to in writing, software distributed 
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 */
package costar.objects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Predicate;

import costar.ConcolicUtil;
import costar.SymbolicField;
import costar.SymbolicVariable;
import gov.nasa.jpf.constraints.api.Variable;
import gov.nasa.jpf.constraints.types.Type;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Heap;

/**
 * Context for storing information about symbolically annotated objects.
 * 
 *
 */
public class SymbolicObjectsContext {

	private final Heap heap;

	private final Map<String, SymbolicVariable<?>> symbolicVars;

	public SymbolicObjectsContext(Heap heap, Predicate<? super String> exclude, Predicate<? super String> include,
			Predicate<? super ClassInfo> excludeSpecial) {
		this.heap = heap;
		this.symbolicVars = new HashMap<>(/* globalSymbolics */);
	}

	public Heap getHeap() {
		return heap;
	}

	public void processObject(ElementInfo ei, String eiName) {
		int numOfFields = ei.getNumberOfFields();
		
		for (int i = 0; i < numOfFields; i++) {
			FieldInfo fi = ei.getFieldInfo(i);
			
			if (ei.getFieldAttr(fi) == null) {
				String name = eiName + "_" + fi.getName();
				starlib.formula.Variable attr = new starlib.formula.Variable(name);
			
				ei.setFieldAttr(fi, attr);

				byte tc = fi.getTypeCode();
				Type<?> t = ConcolicUtil.forTypeCode(tc);
	
				Variable<?> var = Variable.create(t, name);
				SymbolicField<?> symf = new SymbolicField<>(var, ei, fi);
				addSymbolicVar(symf);
				
				if (fi.isReference()) {
					int fiRef = ei.getReferenceField(fi);
					ElementInfo fei = heap.get(fiRef);
										
					if (fei != null) processObject(fei, name);
				}
			}
		}
	}

	public void addSymbolicVar(SymbolicVariable<?> sp) {
		symbolicVars.put(sp.getVariable().getName(), sp);
	}

	public Collection<SymbolicVariable<?>> getSymbolicVars() {
		return symbolicVars.values();
	}

}
