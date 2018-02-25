package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.*;
import static play.data.Form.*;
import play.data.validation.Constraints.*;
import play.mvc.Controller;
import views.html.*;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.TimedConsoleProgressMonitor;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import controllers.FillerTreatment;
import controllers.OWLExistentialReasoner;
import controllers.OWLExistentialReasonerImpl;
import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasoner;
import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;
import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;


public class ApplicationCompare extends Controller {
    
	
    static ArrayList<String> model = new ArrayList<String>();
    static ArrayList<String> beeModel = new ArrayList<String>();	     
    static ArrayList<String> CharacterList = new ArrayList<String>();
    static ArrayList<String> BeesList = new ArrayList<String>();
    static ArrayList<String> KeyDescriptionArraylist = new ArrayList<String>();
    
    static int charCount;
    static int beeCountnumber;
	
    public static ArrayList<String> List1Comments = new ArrayList<String>();
    public static ArrayList<String> CharacterArraylist = new ArrayList<String>();
    public static ArrayList<String> BeeArraylist = new ArrayList<String>();
    
    public static ArrayList<String> SpeciesFeatures = new ArrayList<String>();
    public static ArrayList<String> selectedItems1 = new ArrayList<String>();
    
    public static ArrayList<String> selectedBees = new ArrayList<String>();
    public static ArrayList<String> foundAllFeatures = new ArrayList<String>();
    public static ArrayList<String> foundAll = new ArrayList<String>();
    public static ArrayList<String> foundFeatures = new ArrayList<String>();
    public static ArrayList<String> foundCommonFeatures = new ArrayList<String>();
    public static ArrayList<String> foundCommon = new ArrayList<String>();
    public static ArrayList<String> item1features = new ArrayList<String>();
    public static ArrayList<String> item2features = new ArrayList<String>();
    public static ArrayList<String> Uncommonfeatures = new ArrayList<String>();
    public static String item1;
    public static String item2;
    
	String Path;
	
    //Ontology variables declaration
    public static OWLOntologyManager manager;
	public static File BeeOntologyfile;
	public static OWLOntology BeeCharacteristics;
	public static OWLDataFactory factory1;
	public static ManchesterOWLSyntaxOWLObjectRendererImpl renderer;
	public static FaCTPlusPlusReasonerFactory fppRF;
	public static TimedConsoleProgressMonitor progressMonitor;
	public static OWLReasonerConfiguration config;
	public static OWLReasoner reasoner;
	//public final FillerTreatment fillerTreatment;
	//public static OWLExistentialReasoner Exreasoner;
    
    /**
     * The Ontology form.
     */
    public static class Ontology {
        @Required public ArrayList<String> features;
        public ArrayList<String> selectedFeatures;
        public ArrayList<String> results;
        public ArrayList<Boolean> selected;
        
        public Ontology(ArrayList<String> features, 
        		ArrayList<String> selectedFeatures, 
        		ArrayList<String> results ){
        	this.features = features;
        	this.selectedFeatures = selectedFeatures;
        	this.results = results;
        }
    }
    
    // -- Actions
    
   
    
    public static Result choosefileCompare(){
    	selectedItems1.clear();
    	item1features.clear();
    	item2features.clear();
    	foundAllFeatures.clear();
    	foundCommonFeatures.clear();
    	Uncommonfeatures.clear();
    	
    	return ok(indexchoosefilecompare.render(""));
    	
    }
  
    /**
     * Handles the file upload.
     * @throws OWLOntologyCreationException 
     * @throws InterruptedException 
     */
    public static Result uploadFile() throws OWLOntologyCreationException, InterruptedException {
    	
    	Form<Ontology> ontologyForm = form(Ontology.class);
    	
    	MultipartFormData body = request().body().asMultipartFormData();
    	  FilePart ontologyFile = body.getFile("ontology");
    	  if (ontologyFile != null) {
    	   String fileName = ontologyFile.getFilename();
    	   String contentType = ontologyFile.getContentType(); 
    	   // ontology.get
    	   File file = ontologyFile.getFile();
    	    
    	   try{ 
    		   loadOntology(file.getPath());
    	   }
    	   catch(UnparsableOntologyException ex){
    		   return ok(indexchoosefilecompare.render("Not a valid Ontology File"));
    	   }
    	  
    	  //Initiate the reasoner to classify ontology
    	  if (BeeOntologyfile.exists())
    	  {
    		reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
    		//loadBeeCharacteristics();
    		loadBees();
    	  }
    	    
    	//  System.out.println(KeyDescriptionArraylist);
    	 // Ontology ontology = new Ontology(KeyDescriptionArraylist, null, null);
    	  return ok(viewcompare.render(" "," ", BeeArraylist,item1features,item2features,foundCommonFeatures,Uncommonfeatures));
	    	   
    	  } else {
    	    flash("error", "Missing file");
    	    return ok(index.render("File Not Found"));	
    	  }
    }
    
    /**
     * Handles the ontology query
     * @throws OWLOntologyCreationException 
     */
   // public static Result getResults(List<String> selected){
    public static Result getResults() throws OWLOntologyCreationException{

    	  try{ 
    	    	String[] selected = request().body().asFormUrlEncoded().get("cars");
    	    	 
    	    	selectedItems1.clear();
    	    
    	    	for(int i=0; i< selected.length; i++){
    	    		selectedItems1.add(selected[i]);
    	    	}
    	    
    	    	//if more than 2 or less than 2 selected 
    	    	if (selectedItems1.size() > 2 || selectedItems1.size() < 2)
    	    	{
    	    	
    	    		item1features.clear();
   	    		  item2features.clear();
   	    		selectedItems1.clear();
   	    		foundCommonFeatures.clear();
   	    	Uncommonfeatures.clear();
   	    		  //return ok(view.render("None Selected","",KeyDescriptionArraylist,selectedItems1,beeModel));
   	    		  return ok(viewcompare.render("Please only Select 2 Items", " ", BeeArraylist,item1features,item2features,foundCommonFeatures,Uncommonfeatures));/////change to viewelements
   	    	    	
    	    	}
    	    	
    	     item1 = selectedItems1.get(0);
    	     item2 = selectedItems1.get(1);
    	    	
    	    	displaySpeciesFeatures(selectedItems1);
    	    	
    	    	//String[] selected = params.getAll("selected");
    	    	///return ok("Results:"+ beeModel);
    	    	
    	    	  }  catch(Exception ex){
    	    		  //ex.printStackTrace();
    	    		  item1features.clear();
    	    		  item2features.clear();
    	    		  foundCommonFeatures.clear();
    	    		  //return ok(view.render("None Selected","",KeyDescriptionArraylist,selectedItems1,beeModel));
    	    		  return ok(viewcompare.render("None Selected"," ", BeeArraylist,item1features,item2features,foundCommonFeatures,Uncommonfeatures));/////change to viewelements
    	    	    	 
    	    	  }
    	 
    	    	//return ok(view.render("Selected Features:","Results:",KeyDescriptionArraylist,selectedItems1,beeModel));
    	    	 return ok(viewcompare.render(item1, item2, BeeArraylist,item1features,item2features,foundCommonFeatures,Uncommonfeatures));/////change to viewelements
    	    	 
    	
    }
    
  
//////Get the user selected bees and then using the existential reasoner, query to find the associated features with
	/////the selected bees
/////New method to get the features of a/some bee species, this is where the actual work is done to find query them.
    public static void displaySpeciesFeatures(ArrayList<String> selected) throws OWLOntologyCreationException{
	 
    	
		selectedBees.clear();
		foundAllFeatures.clear();
		foundFeatures.clear();
		foundCommonFeatures.clear();
		foundCommon.clear();
		foundAll.clear();
		item1features.clear();
		item2features.clear();
		Uncommonfeatures.clear();
		//get the selected species/bees
		
		selectedBees.addAll(selected);
		
		//ArrayList<OWLClassExpression> beesIRI = new ArrayList<OWLClassExpression>();
		//beesIRI.clear();
		
		//Declare the existential reasoner and the filler treatment
		
		 OWLObjectProperty props = factory1.getOWLObjectProperty((IRI.create(BeeCharacteristics.getOntologyID()
		   		  .getOntologyIRI().toString() + "#hasDiagnosticFeature")));
		
		
		 final FillerTreatment fillerTreatment = FillerTreatment.MOST_SPECIFIC;
		OWLExistentialReasoner EXreasoner = new OWLExistentialReasonerImpl(reasoner, fillerTreatment);
		 
			
		//System.out.println(u);
	
	//OWLClassExpression ce1 = null;
		// ArrayList<OWLClass> beee = new ArrayList<OWLClass>();
			
			
		  Set<OWLClassExpression> beeCE = new HashSet<OWLClassExpression>();	
		   int beeCount = selectedBees.size();
		  
		 //For each selected bee convert to its IRI
		    for (String sB : selectedBees)
		{
		    	OWLClassExpression ce1 = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
		      		  .getOntologyIRI().toString() + "#" + sB));
			//ce = getOWLModelManager().getOWLExpressionCheckerFactory().getOWLClassExpressionChecker().createObject(className);
			//beesIRI.add(ce1);
			beeCE.add(ce1);
			
		}
		    
		    
		    OWLObjectUnionOf union = factory1.getOWLObjectUnionOf(beeCE);
			  NodeSet<OWLClass> clsesk = EXreasoner.getFillers(union, props);
			 // System.out.println("Union/common");
			  for (Node<OWLClass> p : clsesk)
			  {
					
			    	String S = new String();
			    	S = p.toString();
			    	String newStr = new String();
			    	if (S.contains("#"))
					{
						int i = S.indexOf("#");
						int n = S.indexOf(">");
	
						newStr = S.substring((i+1), n);
					}
					
				
			    	foundCommon.add(newStr);
				 
			 
			  }
			  
			  //get the comments of each diagnostic feature (each common one) to display
			  for (String element : foundCommon)
				{
						
			
				//get the URI of the class (the diagnosticfeature)
				 OWLClass keycharr = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
				  .getOntologyIRI().toString() + "#" + element));    
				 
					String comment = new String();			 
				
				//Initialize the annotation(comment) property label
				OWLAnnotationProperty label = factory1
				   .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
							
				//(keydescription) property, initialize and create the comment property
				OWLAnnotationProperty commentprop = factory1
			     .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
				
				//get the keyDescription annotation property which is a subproperty of the annotation 'comment'
				 Set<OWLAnnotationProperty> keyDescription = commentprop.getSubProperties(BeeCharacteristics);
				//place the sub property 'keyDescription' in the annotation(comment) property label
				 for(OWLAnnotationProperty commentkeydesc : keyDescription)
			 		{
				 		label = commentkeydesc;
					}
				 
				 //get the actual string comments (getAnnotations) under keydescription and add them to the 
				 //character list.
				 Set<OWLAnnotation> comments = keycharr.getAnnotations(BeeCharacteristics, label);
					 	for(OWLAnnotation commentAnnot : comments)
				 		{
					 		comment = renderer.render(commentAnnot.getValue());
					 		//System.out.println(commentAnnot);
						}
					 	
					 	
					 	//////////////////////////////
					 	String S = new String();
				    	S = comment;
				    	if (S.contains("\""))
						{
				    		
							int i = S.indexOf("\"", 2);
							if (Character.isWhitespace(S.charAt(i-1))) {
							//int p = S.indexOf(">");
							S = S.substring(0, i-1);
							S = S.trim();
							S = (S + "\"");
							}
						}
				    	//////////////////////////
					 	
					 	
					 	
					 	//Add the not empty comments to another arraylist to sort and to 
					 	//add to the UI
					 if (!(S.isEmpty()))
							 {
						 foundCommonFeatures.add(S);
						 System.out.println(foundCommonFeatures);
						//model.addElement(comment);
					 }
				
					}
	
			  
	//get the first selected item, and get its associated features
			  Set<OWLClassExpression> beeCE1 = new HashSet<OWLClassExpression>();	
			 
			  //For each selected bee convert to its IRI
			  String firstitem = selectedBees.get(0);
			 
			    	OWLClassExpression cefirst = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
			      		  .getOntologyIRI().toString() + "#" + firstitem));
				//ce = getOWLModelManager().getOWLExpressionCheckerFactory().getOWLClassExpressionChecker().createObject(className);
				//beesIRI.add(ce1);
				beeCE1.add(cefirst);
			
			  
			  //Get the intersection/ALL features of item 1 (first selected item)
			OWLObjectIntersectionOf intersection = factory1.getOWLObjectIntersectionOf(beeCE1);
				  NodeSet<OWLClass> cl = EXreasoner.getFillers(intersection, props);
				 // System.out.println("Intersection/all");
				  for (Node<OWLClass> o : cl)
				  {
					  String S = new String();
				    	S = o.toString();
				    	String newStr = new String();
				    	if (S.contains("#"))
						{
							int i = S.indexOf("#");
							int n = S.indexOf(">");
		
							newStr = S.substring((i+1), n);
						}
							
				    	foundAll.add(newStr);
				 // System.out.println(renderer.render(o.getRepresentativeElement()));
				  }
				  
				  for (String element : foundAll)
					{
							
				
					//get the URI of the class (the diagnosticfeature)
					 OWLClass keycharr = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
					  .getOntologyIRI().toString() + "#" + element));    
					 
						String comment = new String();			 
					
					//Initialize the annotation(comment) property label
					OWLAnnotationProperty label = factory1
					   .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
								
					//(keydescription) property, initialize and create the comment property
					OWLAnnotationProperty commentprop = factory1
				     .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
					
					//get the keyDescription annotation property which is a subproperty of the annotation 'comment'
					 Set<OWLAnnotationProperty> keyDescription = commentprop.getSubProperties(BeeCharacteristics);
					//place the sub property 'keyDescription' in the annotation(comment) property label
					 for(OWLAnnotationProperty commentkeydesc : keyDescription)
				 		{
					 		label = commentkeydesc;
						}
					 
					 //get the actual string comments (getAnnotations) under keydescription and add them to the 
					 //character list.
					 Set<OWLAnnotation> comments = keycharr.getAnnotations(BeeCharacteristics, label);
						 	for(OWLAnnotation commentAnnot : comments)
					 		{
						 		comment = renderer.render(commentAnnot.getValue());
						 		//System.out.println(commentAnnot);
							}
						 	
						 	
						 	//////////////////////////////
						 	String S = new String();
					    	S = comment;
					    	if (S.contains("\""))
							{
					    		
								int i = S.indexOf("\"", 2);
								if (Character.isWhitespace(S.charAt(i-1))) {
								//int p = S.indexOf(">");
								S = S.substring(0, i-1);
								S = S.trim();
								S = (S + "\"");
								}
							}
					    	//////////////////////////
					  //Add the not empty comments to another arraylist to sort and to 
						 	//add to the UI
						 if (!(S.isEmpty()))
								 {
							 	item1features.add(S);
							
							//model.addElement(comment);
						 }
					
						}
	  
				  
				  
		  //get the SECOND selected item, and get its associated features
				  Set<OWLClassExpression> beeCE2 = new HashSet<OWLClassExpression>();	
				 
				  //For each selected bee convert to its IRI
				  String seconditem = selectedBees.get(1);
				 
				    	OWLClassExpression cesecond = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
				      		  .getOntologyIRI().toString() + "#" + seconditem));
					//ce = getOWLModelManager().getOWLExpressionCheckerFactory().getOWLClassExpressionChecker().createObject(className);
					//beesIRI.add(ce1);
					beeCE2.add(cesecond);
				
				  
				  //Get the intersection/ALL features of item 2 (SECOND selected item)
				OWLObjectIntersectionOf intersection2 = factory1.getOWLObjectIntersectionOf(beeCE2);
					  NodeSet<OWLClass> classes = EXreasoner.getFillers(intersection2, props);
					 // System.out.println("Intersection/all");
					  for (Node<OWLClass> o : classes)
					  {
						  String S = new String();
					    	S = o.toString();
					    	String newStr = new String();
					    	if (S.contains("#"))
							{
								int i = S.indexOf("#");
								int n = S.indexOf(">");
			
								newStr = S.substring((i+1), n);
							}
								
					    	foundAllFeatures.add(newStr);
					 // System.out.println(renderer.render(o.getRepresentativeElement()));
					  }
					  
					  for (String element : foundAllFeatures)
						{
								
					
						//get the URI of the class (the diagnosticfeature)
						 OWLClass keycharr = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
						  .getOntologyIRI().toString() + "#" + element));    
						 
							String comment = new String();			 
						
						//Initialize the annotation(comment) property label
						OWLAnnotationProperty label = factory1
						   .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
									
						//(keydescription) property, initialize and create the comment property
						OWLAnnotationProperty commentprop = factory1
					     .getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_COMMENT.getIRI());
						
						//get the keyDescription annotation property which is a subproperty of the annotation 'comment'
						 Set<OWLAnnotationProperty> keyDescription = commentprop.getSubProperties(BeeCharacteristics);
						//place the sub property 'keyDescription' in the annotation(comment) property label
						 for(OWLAnnotationProperty commentkeydesc : keyDescription)
					 		{
						 		label = commentkeydesc;
							}
						 
						 //get the actual string comments (getAnnotations) under keydescription and add them to the 
						 //character list.
						 Set<OWLAnnotation> comments = keycharr.getAnnotations(BeeCharacteristics, label);
							 	for(OWLAnnotation commentAnnot : comments)
						 		{
							 		comment = renderer.render(commentAnnot.getValue());
							 		//System.out.println(commentAnnot);
								}
							 	
							 	
							 	//////////////////////////////
							 	String S = new String();
						    	S = comment;
						    	if (S.contains("\""))
								{
						    		
									int i = S.indexOf("\"", 2);
									if (Character.isWhitespace(S.charAt(i-1))) {
									//int p = S.indexOf(">");
									S = S.substring(0, i-1);
									S = S.trim();
									S = (S + "\"");
									}
								}
						    	//////////////////////////
						  //Add the not empty comments to another arraylist to sort and to 
							 	//add to the UI
							 if (!(S.isEmpty()))
									 {
								 	item2features.add(S);
								
								//model.addElement(comment);
							 }
						
							}	
				  
				  
				  Collections.sort(item1features);
				  Collections.sort(item2features);
				  Collections.sort(foundCommonFeatures);
				  
				  //Get the uncommon features by comparing all the features of each species to the common features
				  
				  for(String item1feat : item1features)
			 		{
				 		
					  
					  if  (!(foundCommonFeatures.contains(item1feat)))
					  {
						  Uncommonfeatures.add(item1feat);
						  
					  }
		 
					}
				  
				  for(String item2feat : item2features)
			 		{
				 		
					  
					  if  (!(foundCommonFeatures.contains(item2feat)))
					  {
						  Uncommonfeatures.add(item2feat);
						  
					  }
		 
					}
				  
				  Collections.sort(Uncommonfeatures);
				 //	System.out.println("uncommob" + Uncommonfeatures);
				  
	
				
 }
    
    
    private static void loadOntology(String Path) throws OWLOntologyCreationException  {
    	
    	//System.load("/Users/danielfuterman/dll/libFaCTPlusPlusJNI.jnilib");
    	//Load the Ontology and declare all ontology variables
		 manager = OWLManager.createOWLOntologyManager();
		 BeeOntologyfile = new File(Path);
		 //Xylocopa_v4
		 //BeeKeyOntology_V05
		 //BeeKeyOntology_v07
		 // AuronaMac:Applications/BeeKeyOntology_v07.owl
		 //C:/Windows/System32/BeeKeyOntology_v07.owl
		 if (BeeOntologyfile.exists())
			 
		 {
			 	
		 BeeCharacteristics = manager.loadOntologyFromOntologyDocument(BeeOntologyfile);
		 factory1 = manager.getOWLDataFactory();
		 
		 //Print what and where from out
		 System.out.println("Loaded ontology: " + BeeCharacteristics);
	     IRI documentIRI = manager.getOntologyDocumentIRI(BeeCharacteristics);
	     System.out.println("    from: " + documentIRI);

	    //Renderer to get the string text
	    renderer = new ManchesterOWLSyntaxOWLObjectRendererImpl();
	    
	     fppRF = new FaCTPlusPlusReasonerFactory();
	     progressMonitor = new TimedConsoleProgressMonitor();
	     config = new SimpleConfiguration(progressMonitor);
	     config.getProgressMonitor();
	        // Create a reasoner that will reason over our ontology and its imports
	        // closure. Pass in the configuration.
	        //OWLReasoner reasoner = Rf.createReasoner(BeeCharacteristics, config);
	     	// System.out.println("before reasoner create");
	     reasoner = fppRF.createReasoner(BeeCharacteristics, config);
		 }
    }

    /////////////////Loading the bees first one
    public static void loadBees() throws InterruptedException, OWLOntologyCreationException{
		
    	
    	BeeArraylist.clear();
    	BeeArraylist = LoadBeeSpecies();
    	 Collections.sort(BeeArraylist);
	
	
    	
    }
    
    //////////////////loading the actual species and looping through till the bottom nodes
    
    public static ArrayList<String> LoadBeeSpecies() throws OWLOntologyCreationException{
		//Retrieve the the sub classes of KeyCharacteristic, loop through
		//to find the bottom level of classes to return
				
				ArrayList<String> Species = new ArrayList<String>();
				Species.clear();
				//  OntologyLoad OntLoad = new OntologyLoad();
			      //  OntLoad.LoadOnly();
	        
		//Reference the KeyCharacteristics Class
				 OWLClass KeyChar = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
				    		  .getOntologyIRI().toString() + "#Organism"));
    	
				// System.out.println("    first get subclasses ");
				 
		//Get all the subclasses of KeyCharacteristic and loop through to return the bottom level classes
		//direct subclasses should be retrieved (true) or if all subclasses (descendant) (false)
				 NodeSet<OWLClass> subClasses1 = reasoner.getSubClasses(KeyChar, false);
				 
				    for (Node<OWLClass> cls: subClasses1){
  	 	
				    	String firstSubClass = new String();
				    	firstSubClass = renderer.render(cls.getRepresentativeElement());
				    	
				    	String S = new String();
				    	S = cls.toString();
				    	String newStr = new String();
				    	if (S.contains("#"))
						{
							int i = S.indexOf("#");
							int p = S.indexOf(">");
		
							newStr = S.substring((i+1), p);
						}
				    	
				    	OWLClass KeyCharSub1 = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
					    		  .getOntologyIRI().toString() + "#" + firstSubClass));
    		    	
				    	for (Node<OWLClass> subcls: reasoner.getSubClasses(KeyCharSub1, true)){
	    		
				    		if (subcls.isBottomNode() && (!(firstSubClass.contains("Nothing")))){
			    		
				    			Species.add(newStr);		    		
				    		}
				    			else{
		    			
				    			}
				    	}
				    		
				    }
	
				  Collections.sort(Species);
				    return Species;
    }
    
   
}
