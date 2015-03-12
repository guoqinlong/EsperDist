package dist.esper.experiment;

import java.util.*;

import dist.esper.experiment.QueryGenerator.IntPair;
import dist.esper.experiment.util.MultiLineFileWriter;
import dist.esper.external.event.EventInstanceGenerator;

public class QueryGeneratorMain {
	public static void main(String[] args){
		String templatesFilePath="query/templates.txt";
		String queriesFilePath="query/queries.txt";
		QueryGenerator qg=new QueryGenerator();
		try {
			qg.readTemplatesFromFile(templatesFilePath);
			System.out.format("read %d templates from %s\n", qg.templateStrs.size(), templatesFilePath);
			initQueryGeneratorEvents(qg);
			
			IntPair[] pairs={
				new IntPair(1,20),
				new IntPair(2,10),
				new IntPair(3,5),
				new IntPair(4,2),
				new IntPair(5,1),
			};
			
			List<String> queryList=qg.generateQuries(Arrays.asList(pairs));
			MultiLineFileWriter.writeToFile(queriesFilePath, queryList);
			System.out.format("generate %d queries, and write to %s\n", 
					queryList.size(), queriesFilePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initQueryGeneratorEvents(QueryGenerator qg){
//		EventInstanceGenerator eventGenA=EventGeneratorFactory.genEventInstanceGeneratorA();
//		EventInstanceGenerator eventGenB=EventGeneratorFactory.genEventInstanceGeneratorB();
//		EventInstanceGenerator eventGenC=EventGeneratorFactory.genEventInstanceGeneratorC();
//		EventInstanceGenerator eventGenD=EventGeneratorFactory.genEventInstanceGeneratorD();
//		EventInstanceGenerator eventGenE=EventGeneratorFactory.genEventInstanceGeneratorE();
//		
//		qg.addEventPrototype("A", eventGenA.getFieldGeneratorMap());
//		qg.addEventPrototype("B", eventGenB.getFieldGeneratorMap());
//		qg.addEventPrototype("C", eventGenC.getFieldGeneratorMap());
//		qg.addEventPrototype("D", eventGenD.getFieldGeneratorMap());
//		qg.addEventPrototype("E", eventGenE.getFieldGeneratorMap());
//		
//		qg.addEventName("A", "AJ");
//		qg.addEventName("A", "AK");
//		
//		qg.addEventName("B", "BJ");
//		qg.addEventName("B", "BK");
//		
//		qg.addEventName("C", "CJ");
//		qg.addEventName("C", "CK");
//		
//		qg.addEventName("D", "DJ");
//		qg.addEventName("D", "DK");
//		
//		qg.addEventName("E", "EJ");
//		qg.addEventName("E", "EK");
		List<EventInstanceGenerator> eventGenList=genEventInstanceGenerators();
		for(EventInstanceGenerator eg: eventGenList){
			qg.addEventPrototype(eg.getCategoryName(), eg.getFieldGeneratorMap());
			qg.addEventName(eg.getCategoryName(), eg.getEventName());
		}
	}
	
	public static List<EventInstanceGenerator> genEventInstanceGenerators(){
		//List<EventInstanceGenerator> eigList=new ArrayList<EventInstanceGenerator>();
		EventInstanceGenerator[] eventGens={
				EventGeneratorFactory.genEventInstanceGenerator("A", "AJ"),
				EventGeneratorFactory.genEventInstanceGenerator("A", "AK"),
				EventGeneratorFactory.genEventInstanceGenerator("B", "BJ"),
				EventGeneratorFactory.genEventInstanceGenerator("B", "BK"),
				EventGeneratorFactory.genEventInstanceGenerator("C", "CJ"),
				EventGeneratorFactory.genEventInstanceGenerator("C", "CK"),
				EventGeneratorFactory.genEventInstanceGenerator("D", "DJ"),
				EventGeneratorFactory.genEventInstanceGenerator("D", "DK"),
				EventGeneratorFactory.genEventInstanceGenerator("E", "EJ"),
				EventGeneratorFactory.genEventInstanceGenerator("E", "EK"),
		};
		return Arrays.asList(eventGens);
	}
}
