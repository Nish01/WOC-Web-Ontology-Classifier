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

import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasoner;
import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;
import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;


public class ApplicationBoth extends Controller {
    
	
    static ArrayList<String> model = new ArrayList<String>();
    static ArrayList<String> beeModel = new ArrayList<String>();	     
    static ArrayList<String> CharacterList = new ArrayList<String>();
    static ArrayList<String> BeesList = new ArrayList<String>();
    static ArrayList<String> KeyDescriptionArraylist = new ArrayList<String>();
    
    //new arrays for one page
    public static ArrayList<String> subKeyDescriptionArraylist = new ArrayList<String>();
    public static ArrayList<String> subselectedItems1 = new ArrayList<String>();
    public static ArrayList<String> foundSpecies = new ArrayList<String>();
    public static ArrayList<String> specieModel = new ArrayList<String>();
    public static ArrayList<String> allandFound = new ArrayList<String>();
    
    
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
    public static ArrayList<String> selectedElements = new ArrayList<String>();
    public static ArrayList<String> allFeatures = new ArrayList<String>();
    
    
    public static int featureCount;
    public static int foundElementCount;
    public static int selectedfeatcount;
    public static int Restfeaturescount;
   
    public static int commonFeatCount;
    public static String Count;
    public static int checkcount;
    
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
    
    
    public static Result home(){
    	return ok(index.render(""));
    }
    
    public static Result chooseBoth(){
    	selectedItems1.clear();
    	beeModel.clear();
    	
    	return ok(indexchooseboth.render(""));
    }
    
   
   // public static Result choosefile(){
    //	return ok(indexchoosefile.render(""));
   // }
  
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
    		   return ok(index.render("PLEASE NOTE: You tried to upload a non valid Ontology File"));
    	   }
    	  
    	  //Initiate the reasoner to classify ontology
    	  if (BeeOntologyfile.exists())
    	  {
    		reasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
    		loadBeeCharacteristics();
    		loadBees();
    	  }
    	    
    	  featureCount = KeyDescriptionArraylist.size();
    	 
    	  foundElementCount = -10;
    	  selectedfeatcount = -10;
    	  commonFeatCount = -10;
    	  Restfeaturescount = -10;
    	  
    	  checkcount = 1;
    	 
    	//  System.out.println(KeyDescriptionArraylist);
    	 // Ontology ontology = new Ontology(KeyDescriptionArraylist, null, null);
    	  return ok(viewboth.render("","Elements",featureCount,foundElementCount,selectedfeatcount,KeyDescriptionArraylist,
    			  selectedItems1,beeModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
    	    
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

    	
    	//DynamicForm requestData = form().bindFromRequest();
    	//System.out.println(request().body().asFormUrlEncoded().get("selected"));
    	  try{ 
    	String[] selected = request().body().asFormUrlEncoded().get("cars");
    	 
    	
    	
    	selectedItems1.clear();
    
    		
    	
    	for(int i=0; i< selected.length; i++){
    		selectedItems1.add(selected[i]);
    	}
    	
    	
   /////////////////FEATURES   use the selected features
    	subselectedItems1.clear();
    	subselectedItems1.addAll(selectedItems1);
    	Collections.sort(subselectedItems1);
    	
    	selectedfeatcount = selectedItems1.size();
    	
    	
    	subKeyDescriptionArraylist.clear();
    	subKeyDescriptionArraylist.addAll(KeyDescriptionArraylist);
    	
    	//subKeyDescriptionArraylist.removeAll(subselectedItems1);
    	
    	
    ///////////////	//ELEMENTS  get the species
    	displayBees(selectedItems1);
    	
    //add the found species into the speciemodel arraylist 
    	for (String selectedItem : foundSpecies)
		{
    		 specieModel.add(selectedItem);
			//addElement(selectedItem);
			
		}
    	
    			//print it out
    			//System.out.println("founds bees:" + specieModel);
    	
    	Collections.sort(specieModel);

    	//////////FEATURES get the common features of the returned elements (bee species) and remove the duplicates
    	//in foundcommonfeatures and then add them all to subselecteditems1 to display in the list
    	displaySpeciesFeatures(foundSpecies);
    	
    	foundCommonFeatures.removeAll(selectedItems1);
    	Collections.sort(foundCommonFeatures);
    	commonFeatCount = foundCommonFeatures.size();
    	
    	for (String selectedItem : foundCommonFeatures)
		{
			subselectedItems1.add(selectedItem);
			//addElement(selectedItem);
			
		}
    	
    	/////ALL the remainder features of the found species
    	foundAllFeatures.removeAll(subselectedItems1);
    	Collections.sort(foundAllFeatures);
    	Restfeaturescount = foundAllFeatures.size();
    	
    	
    	for (String selectedItem : foundAllFeatures)
		{
			subselectedItems1.add(selectedItem);
			//addElement(selectedItem);
			
		}
    	
    	
    	subKeyDescriptionArraylist.removeAll(subselectedItems1);
    	Collections.sort(subKeyDescriptionArraylist);	
    	
    	for (String selectedItem : subKeyDescriptionArraylist)
		{
			subselectedItems1.add(selectedItem);
			//addElement(selectedItem);
			
		}
    	
    	
    	//////////ELEMENTS  sort the arrays into one for the bee species. Remove the found elements from all, then add the remainder
    	// to the array speciemodel to display in the list. 

    	foundElementCount = specieModel.size();
    	
    	allandFound.clear();
    	allandFound.addAll(beeModel);
    	
    	allandFound.removeAll(specieModel);
    	//System.out.println("all bees:" + allandFound);
    	
		Collections.sort(allandFound);	  
		for (String selectedItem : allandFound)
		{
    		 specieModel.add(selectedItem);
			//addElement(selectedItem);
			
		}
    		        	
			
		
		featureCount = subselectedItems1.size();
		
		checkcount = 2;
		
    	
    	  }  catch(Exception ex){
    		 // ex.printStackTrace();
    		 
    		  //beeModel.clear();
    		  if (checkcount == 1){
    			  return ok(viewboth.render("None Selected","Elements",featureCount,foundElementCount,selectedfeatcount,KeyDescriptionArraylist,
    	    			  selectedItems1,beeModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
    		  }
    		  else{
    			  return ok(viewboth.render("None Selected","Elements",featureCount,foundElementCount,selectedfeatcount,
        				  subselectedItems1,selectedItems1,specieModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
        	    	
    		  }
    		 
    	  }
    	return ok(viewboth.render("Selected Features:","Elements:",featureCount,foundElementCount,selectedfeatcount,
    			subselectedItems1,selectedItems1,specieModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
    	
    	//return ok(results.render(selectedItems1,beeModel));
    
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

    
    public static void loadBeeCharacteristics() throws InterruptedException, OWLOntologyCreationException{
		//Gets the Key characteristics from the ontology within another method,
		//LoadKeyCharacteristics() then places them into an arraylist and then into the listmodel
		//to display on the interface
		
			
    		CharacterArraylist.clear();
			CharacterArraylist = LoadKeyCharacteristics();
			//ArrayList<String> KeyDescriptionArraylist = new ArrayList<String>();
			//pBar.close();
			List1Comments.clear();
			KeyDescriptionArraylist.clear();
		   
			//CharacterArraylist.add("char1"); 
			// Here we take each element (each KeyCharacteristic) in the characterarraylist
			// and get the associated comment and then the subproperty of comment 
			// (keydescription) to be displayed on the UI
		for (String element : CharacterArraylist)
		{
				//model.addElement(element);
				
	
		//get the URI of the class (the KeyCharacteristic)
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
		    	String newStr = new String();
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
			 	
			 	//add ALL of the annotations to one array List1Comments
			 	//even the empty annotations
			 	List1Comments.add(S);
			 	
			 	//Add the not empty comments to another arraylist to sort and to 
			 	//add to the UI
			 if (!(S.isEmpty()))
					 {
				 KeyDescriptionArraylist.add(S);
				//model.addElement(comment);
			 }
		
			}
			
		//sort the descriptions and then add them to the listbox on the UI
		Collections.sort(KeyDescriptionArraylist);
		
		
	
	
		}
    
    public static ArrayList<String> LoadKeyCharacteristics() throws OWLOntologyCreationException{
		//Retrieve the the sub classes of KeyCharacteristic, loop through
		//to find the bottom level of classes to return
				
				ArrayList<String> Characteristics = new ArrayList<String>();
				Characteristics.clear();
				//  OntologyLoad OntLoad = new OntologyLoad();
			      //  OntLoad.LoadOnly();
	        
		//Reference the KeyCharacteristics Class
				 OWLClass KeyChar = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
				    		  .getOntologyIRI().toString() + "#DiagnosticFeature"));
    	
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
			    		
				    			Characteristics.add(newStr);		    		
				    		}
				    			else{
		    			
				    			}
				    	}
				    		
				    }
	
				  Collections.sort(Characteristics);
				    return Characteristics;
    }
    
    
    
    /////////////////Loading ALL the bees first one
    public static void loadBees() throws InterruptedException, OWLOntologyCreationException{
		
    	
    //	BeeArraylist.clear();
    	//BeeArraylist = LoadBeeSpecies();
    	 //Collections.sort(BeeArraylist);
	
    	 beeModel.clear();
    	 beeModel = LoadBeeSpecies();
     	 Collections.sort(beeModel);
 	
    	
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
    
    
    
    
    
    
    
    public static void displayBees(ArrayList<String> selected) throws OWLOntologyCreationException{

		//displayBees(): Gets the user selected info (getUserinfo()) then uses that to 
		//query the ontology and find the bees which match the characteristics (findBees(CharacterArraylistSelected))
		
		
			
			ArrayList<String> CharacterArraylistSelected = new ArrayList<String>();	
			ArrayList<String> CharacterArraylistSelected2 = new ArrayList<String>();	
			 CharacterArraylistSelected.clear();
			 CharacterArraylistSelected2.clear();
			
		/* getUserinfo: Takes all user input selected characteristics and stores in an arraylist
		* returns the array of characteristics*/
			CharacterArraylistSelected = selected;
			String s = new String();
			int i = 0;
			//for each selected keydescription, find the index of where in the arraylist: List1Comments
			//it is and place into i.
			//Then find the corresponding KeyCharacteristic in the arraylist: CharacterArraylist
			//with the same index and add that KeyCharacteristic to the arraylist: CharacterArraylistSelected2
			
			
			/**
			 * TODO
			 */
			
			for (String Keydescription : CharacterArraylistSelected)
			{
				//s = ( "\""+Keydescription+"\"");
				i = List1Comments.indexOf(Keydescription);
				s = CharacterArraylist.get(i);
				CharacterArraylistSelected2.add(s);
			}
			
			//System.out.println(i);
			//System.out.println(s);
						
			//BeeSpecies b = new BeeSpecies();
			ArrayList<String> BeesArraylist = new ArrayList<String>();
			
		//findBees(ArrayList<String> info): @param is the arraylist of user selected characteristics
		//which are used to query the set of bees which have a hasKeyCharacteristic relationship with 
		//all of them		
			
			
			/**
			 * TODO
			 */
			//BeesArraylist = findBees(CharacterArraylistSelected2);
			BeesArraylist = findBees(CharacterArraylistSelected2);
			
			
			
			 foundSpecies.clear(); 
			 specieModel.clear();
			
			//BeesArraylist = b.findBees(CharacterArraylistSelected);
			
			//beeModel.clear();
		
		//add found bees to beemodel list on the UI
			for (String selectedItem : BeesArraylist)
			{
				foundSpecies.add(selectedItem);
				//addElement(selectedItem);
				
			}

		//above will be getbees	//displaybees(bees)
			//below will be display bees method called here
			//BeesList.add(bees);
			//loadingBeesDialog.setVisible(false);
		//}

			//beeCountnumber = (BeesList.getModel().getSize());
			//beeCount.setText("" + beeCountnumber);
			
			
			//this.setEnabled(true);
			
			//takes the array of bees and outputs it to a label etc on the frame
		}
    
    public static ArrayList<String> findBees(ArrayList<String> info) throws OWLOntologyCreationException{
    	
		//findBees(ArrayList<String> info): @param is the arraylist of user selected characteristics
		//which are used to query the set of bees which have a hasDiagnosticFeature relationship with 
		//all of them
		
		//Instance of the hasKeyCharacteristic object property
	     OWLObjectProperty hasKeyChar = factory1.getOWLObjectProperty((IRI.create(BeeCharacteristics.getOntologyID()
	   		  .getOntologyIRI().toString() + "#hasDiagnosticFeature")));
 
	    ArrayList<OWLClass> Arraylist1 = new ArrayList<OWLClass>();
			//String bees = (info + "   are bee characteristics");
	    
	   //loop through the user selected info and create their IRIs and add to an arraylist
			for (String Item : info)
			{
				OWLClass Char = factory1.getOWLClass(IRI.create(BeeCharacteristics.getOntologyID()
			      		  .getOntologyIRI().toString() + "#" + Item));
				
					Arraylist1.add(Char);
			//	BeesArraylist1.add(Item + " Bee 1");
			}
			
			    Set<OWLClassExpression> userkeys = new HashSet<OWLClassExpression>();
		//loop throught the arraylist of user selected IRIs and add them all to a hashset userkeys	    
		//along with the hasKeychar object property
			    for (OWLClass userInfo : Arraylist1)
			    {
			
			    	userkeys.add(factory1.getOWLObjectSomeValuesFrom(hasKeyChar,
					 userInfo));
	  			
			    }
			
		 ArrayList<String> BeesArraylistFinal = new ArrayList<String>();
		 BeesArraylistFinal.clear();
		 
		 //Instantiate an intersection of all the classes with all the selected characteristics
		//and the object property hasKeyChar
		  OWLObjectIntersectionOf intersection = factory1.getOWLObjectIntersectionOf(userkeys);
		 
		 // System.out.println(" just before get subclasses of fginding bees");
		
		//get all subclasses of the intersection
		  NodeSet<OWLClass> foundBees2 = reasoner.getSubClasses(intersection, false);
  
		//loop through the found bees and add each bee to the arraylist BeesArraylistFinal
		// and then return BeesArraylistFinal
		  for (Node<OWLClass> bee2 : foundBees2)
			{
				 
				 if (!(bee2.isBottomNode()))
				 {
				// System.out.println("hope  " + renderer.render(bee2.getRepresentativeElement()));
				// BeesArraylistFinal.add(OntLoad.renderer.render(bee2.getRepresentativeElement()));
				
				 OWLClass beeFound = factory1.getOWLClass
						 (IRI.create(BeeCharacteristics.getOntologyID()
			    		  .getOntologyIRI().toString() + "#" + 
			    		  renderer.render(bee2.getRepresentativeElement())));
				 	
				 String S = new String();
				 S = bee2.toString();
				 String newBeeStr = new String();
			    	if (S.contains("#"))
					{
						int i = S.indexOf("#");
						int p = S.indexOf(">");
						
						
						newBeeStr = S.substring((i+1), p);
					}
			    	
					// System.out.println(beeFound);
				 BeesArraylistFinal.add(newBeeStr);
		
				 }
				
			}
		
			 if (BeesArraylistFinal.isEmpty())
			 {
			 BeesArraylistFinal.add("There are no results that match "
	 		 		+ "your Diagnostic Features Selection");
			 }
			 
			 Collections.sort(BeesArraylistFinal);
			 return BeesArraylistFinal;

	}
    
    /////GET the bee features, from the right hand listbox of elements
    
    public static Result getResultsBoth() throws OWLOntologyCreationException{

  	  try{ 
  	    	String[] selected = request().body().asFormUrlEncoded().get("species");
  	    	 
  	  	selectedElements.clear();
  	    
  	    	for(int i=0; i< selected.length; i++){
  	    		selectedElements.add(selected[i]);
  	    	}
  	    // allFeatures
  	    	
  	    	displaySpeciesFeatures(selectedElements);
  	    	
  	    	
  	    	
  //////////FEATURES get the common features of the returned elements (bee species) and remove the duplicates
  	    	//in foundcommonfeatures and then add them all to subselecteditems1 to display in the list
  	    	subselectedItems1.clear();
  	    	
  	    	selectedfeatcount = 0;
  	    	
  	    	subKeyDescriptionArraylist.clear();
  	    	subKeyDescriptionArraylist.addAll(KeyDescriptionArraylist);
  	    	subKeyDescriptionArraylist.removeAll(foundCommonFeatures);
  	    	subKeyDescriptionArraylist.removeAll(foundAllFeatures);
  	    	foundAllFeatures.removeAll(foundCommonFeatures);
  	    	
  	    	commonFeatCount = foundCommonFeatures.size();
  	    	
  	    	for (String selectedItem : foundCommonFeatures)
  			{
  				subselectedItems1.add(selectedItem);
  				//addElement(selectedItem);
  				
  			}
  	    	
  	    	/////ALL the remainder features of the found species
  	    	
  	    	Collections.sort(foundAllFeatures);
  	    	Collections.sort(subselectedItems1);
  	    	Restfeaturescount = foundAllFeatures.size();
  	    	
  	    	
  	    	for (String selectedItem : foundAllFeatures)
  			{
  				subselectedItems1.add(selectedItem);
  				//addElement(selectedItem);
  				
  			}
  	    	
  	    	
  	    
  	    	Collections.sort(subKeyDescriptionArraylist);	
  	    	
  	    	for (String selectedItem : subKeyDescriptionArraylist)
  			{
  				subselectedItems1.add(selectedItem);
  				//addElement(selectedItem);
  				
  			}
  	    	
  	    	
  	    	
  	    	
  	    	
  	    	////////////////Sort the selected Species/elements and all the elements
  	    	 specieModel.clear();
  	    	 specieModel.addAll(selectedElements);
  	    	 
  	    	 allandFound.clear();
  	    	 allandFound.addAll(beeModel);
  	    	 
  	    	 allandFound.removeAll(specieModel);
  	    	 
  	    	
  	    	 Collections.sort(specieModel);
  	    	 Collections.sort(allandFound);
  	    	 foundElementCount = specieModel.size();
  	    	
  	    	for (String selectedItem : allandFound)
  	  		{
  	      		 specieModel.add(selectedItem);
  	  			//addElement(selectedItem);
  	  			
  	  		}
  	      	
  	      			//print it out
  	      			//System.out.println("founds bees:" + specieModel);
  	      	
  	    	 featureCount = subselectedItems1.size();
  	    	checkcount = 2;
  	    	//String[] selected = params.getAll("selected");
  	    	///return ok("Results:"+ beeModel);
  	    	
  	    	  }  catch(Exception ex){
  	    		  //ex.printStackTrace();
  	    		  //foundAllFeatures.clear();
  	    		  //foundCommonFeatures.clear();
  	    		  //return ok(view.render("None Selected","",KeyDescriptionArraylist,selectedItems1,beeModel));
  	    		  //return ok(viewboth.render("None Selected",BeeArraylist,selectedItems1,foundAllFeatures,foundCommonFeatures));/////change to viewelements
  	    		 if (checkcount == 1){
  	    			  return ok(viewboth.render("None Selected","Elements",featureCount,foundElementCount,selectedfeatcount,KeyDescriptionArraylist,
  	    	    			  selectedItems1,beeModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
  	    		  }
  	    		  else{
  	    		  return ok(viewboth.render("None Selected","Results:",featureCount,foundElementCount,selectedfeatcount,
  	    				subselectedItems1,selectedItems1,specieModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
  	      	 
  	    		  }
  	    	  }
  	 
  	    	//return ok(view.render("Selected Features:","Results:",KeyDescriptionArraylist,selectedItems1,beeModel));
  	    	// return ok(viewboth.render("Selected Elements:",BeeArraylist,selectedItems1,foundAllFeatures,foundCommonFeatures));/////change to viewelements
  	    	return ok(viewboth.render("Selected Features:","Results:",featureCount,foundElementCount,selectedfeatcount,
  	    			subselectedItems1,selectedItems1,specieModel,selectedElements,allFeatures,commonFeatCount,Restfeaturescount));
  	    	 
  	
  }
    
    

    public static void displaySpeciesFeatures(ArrayList<String> selected) throws OWLOntologyCreationException{
    	
	allFeatures.clear();
	selectedBees.clear();
	foundAllFeatures.clear();
	foundFeatures.clear();
	foundCommonFeatures.clear();
	foundCommon.clear();
	foundAll.clear();
	
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
	    
	    //intersection/common features
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

		  /////////COMMENTS START
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
					 //System.out.println(foundCommonFeatures);
					//model.addElement(comment);
				 }
			
				}

		  /////////COMMENTS END
		  
		  
		  //Get the union/ALL features
		OWLObjectIntersectionOf intersection = factory1.getOWLObjectIntersectionOf(beeCE);
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
			  
			  //////COMENTS START
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
				    	//////////////////////////COMMENTS END
				  //Add the not empty comments to another arraylist to sort and to 
					 	//add to the UI
					 if (!(S.isEmpty()))
							 {
						 foundAllFeatures.add(S);
						
						//model.addElement(comment);
					 }
				
					}
  
			  Collections.sort(foundAllFeatures);
			  Collections.sort(foundCommonFeatures);
			  allFeatures.addAll(foundAllFeatures);

			  
		
    }
    
}
