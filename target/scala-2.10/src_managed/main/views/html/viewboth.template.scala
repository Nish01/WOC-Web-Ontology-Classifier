
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object viewboth extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template12[String,String,Integer,Integer,Integer,List[String],List[String],List[String],List[String],List[String],Integer,Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, messagef: String, count: Integer, beefoundcount: Integer, selectedfeatcount: Integer, 
features: List[String], selected: List[String], results: List[String], selectedElements: List[String], 
allFeatures: List[String], commonFeatCount: Integer, Restfeaturescount: Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*3.81*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main(title = "Web Ontology Classifier/Viewer")/*7.48*/ {_display_(Seq[Any](format.raw/*7.50*/("""
    
    
     <div class="topdiv">
    	  <div class="leftelement">
    
    		<h1 id="container">Diagnostic Features:</h1>
      
      
     		 """),_display_(Seq[Any](/*16.10*/form(action = routes.ApplicationBoth.getResults, args = 'id -> "carform")/*16.83*/ {_display_(Seq[Any](format.raw/*16.85*/("""  
      
				<select id="cars" name="cars" multiple="multiple" size="40">

				"""),_display_(Seq[Any](/*20.6*/for(index <- 0 until features.size()) yield /*20.43*/{_display_(Seq[Any](format.raw/*20.44*/("""
		    
				<option value=""""),_display_(Seq[Any](/*22.21*/features(index))),format.raw/*22.36*/("""" name="selected">"""),_display_(Seq[Any](/*22.55*/features(index))),format.raw/*22.70*/("""</option>
		
			""")))})),format.raw/*24.5*/("""
      
      <p class="buttons">
         
             <input type="submit">
      </p>
        
       <p>
         Count: """),_display_(Seq[Any](/*32.18*/(count))),format.raw/*32.25*/("""
             
        </p>
      """)))})),format.raw/*35.8*/("""
      
      
      </div>
      
    <div class="middleelement">
     
      <h1 id="container">Elements:</h1>
      
      
      """),_display_(Seq[Any](/*45.8*/form(action = routes.ApplicationBoth.getResultsBoth, args = 'id -> "speciesform")/*45.89*/ {_display_(Seq[Any](format.raw/*45.91*/("""  
      
		<select id="species" name="species" multiple="multiple" size="40">

		"""),_display_(Seq[Any](/*49.4*/for(index <- 0 until results.size()) yield /*49.40*/{_display_(Seq[Any](format.raw/*49.41*/("""
		    
	<option value=""""),_display_(Seq[Any](/*51.18*/results(index))),format.raw/*51.32*/("""" name="selected">"""),_display_(Seq[Any](/*51.51*/results(index))),format.raw/*51.65*/("""</option>
		
		""")))})),format.raw/*53.4*/("""

   	   	<p class="buttons">
         
             <input type="submit">
    	  </p>
       
      """)))})),format.raw/*60.8*/("""
     
		</div>
		 
      <div class="rightelement">
		    
		    
      
 
		<h4>Colour Identification Key:</h4>
 		<p> <span id="bluekey">Blue: </span> Selected/Common Features | Selected/Found Elements</p>
 		<p><span id="redkey">Red:</span> Common Features </p>
 		<p><span id="greenkey">Green:</span> Uncommon features to found elements</p>
 		
 		<br>
 		
 		<!-- <h1>"""),_display_(Seq[Any](/*76.14*/(message))),format.raw/*76.23*/("""</h1>
		 -->
		
		<p id="images1" style="visibility: hidden;">
		
		  <img src=""""),_display_(Seq[Any](/*81.16*/routes/*81.22*/.Assets.at("images/21.jpg"))),format.raw/*81.49*/("""" alt="Known distribution of 
		  Plesianthidium calescens and Plesianthidium richtersveldi" height="228" width="187">
		  <br>
		 Known distribution of 
		  Plesianthidium calescens and Plesianthidium richtersveldi.
		 </p>
		 
    	<p id="images2" style="visibility: hidden;">
    	
      	<img src=""""),_display_(Seq[Any](/*90.19*/routes/*90.25*/.Assets.at("images/22.jpg"))),format.raw/*90.52*/("""" alt="Plesianthidium richtersveldi. a. 
     	 Female habitus. b. Female face. c. Male habitus. d. Male face" height="234" width="283">
     	<br>
     	Plesianthidium richtersveldi. a. 
     	Female habitus. b. Female face. c. Male habitus. d. Male face.
		 
    
   
		    </p>
		    
		    
         
   </div>
   </div>
   
  
  
  
  
       <div class="topdiv">
    	  <div class="leftelement">
    	  
    	  
		<textarea id="tx" rows="4" cols="50">

</textarea>
	  
		 </div>
		  <div class="middleelement" style="display: none;">
		
		 <h1>All Features</h1>
      
  
      
		
		<ul>

		"""),_display_(Seq[Any](/*127.4*/for(index <- 0 until allFeatures.size()) yield /*127.44*/{_display_(Seq[Any](format.raw/*127.45*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*130.15*/allFeatures(index))),format.raw/*130.33*/("""</span>
			</li>
		
		""")))})),format.raw/*133.4*/("""
		
		</ul>
		
		
		<h1>Test</h1>
      
      """),_display_(Seq[Any](/*140.8*/for(index <- 0 until selected.size()) yield /*140.45*/{_display_(Seq[Any](format.raw/*140.46*/("""
		    
		  
		    	<span>"""),_display_(Seq[Any](/*143.15*/selected(index))),format.raw/*143.30*/("""</span>
			
		
		""")))})),format.raw/*146.4*/("""
 
      
		
		 </div>
		
		  <div class="rightelement" style="display: none;">
		 
		<h1>Common Features</h1>
      
 		<p id="demo"></p>
 		<p id="demo2">"""),_display_(Seq[Any](/*157.19*/beefoundcount)),format.raw/*157.32*/("""</p>
 		<p id="featcount">"""),_display_(Seq[Any](/*158.23*/selectedfeatcount)),format.raw/*158.40*/("""</p>
 		<p id="commonFeatCount">"""),_display_(Seq[Any](/*159.29*/commonFeatCount)),format.raw/*159.44*/("""</p>
 		<p id="Restfeaturescount">"""),_display_(Seq[Any](/*160.31*/Restfeaturescount)),format.raw/*160.48*/("""</p>
 		
 		
 		<h1>Selected Elements:</h1>
		<ul>

		"""),_display_(Seq[Any](/*166.4*/for(index <- 0 until selectedElements.size()) yield /*166.49*/{_display_(Seq[Any](format.raw/*166.50*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*169.15*/selectedElements(index))),format.raw/*169.38*/("""</span>
			</li>
		
		""")))})),format.raw/*172.4*/("""
		
		</ul>
 		
 		
	
		 </div>
		  </div>  
		  
 <script>
		  
		  document.getElementById("bluekey").style.color = "blue";
		  document.getElementById("redkey").style.color = "red";
		  document.getElementById("greenkey").style.color = "green";
		  
		  
		  var array1 = new Array();
  
			  //selected features colour
		  
		   var selectfeatcount = document.getElementById("featcount").innerHTML; 
		
		  if (selectfeatcount == -10) """),format.raw/*194.33*/("""{"""),format.raw/*194.34*/("""
    		
			"""),format.raw/*196.4*/("""}"""),format.raw/*196.5*/(""" else """),format.raw/*196.11*/("""{"""),format.raw/*196.12*/("""
  			
  			
  				for (i = 0; i < selectfeatcount; i++) """),format.raw/*199.45*/("""{"""),format.raw/*199.46*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "blue";
		 			 array1.push(cars[i].value);
				"""),format.raw/*202.5*/("""}"""),format.raw/*202.6*/("""
  			
  			"""),format.raw/*204.6*/("""}"""),format.raw/*204.7*/("""
		  
		  
		  //common features colour
		  
		   var commonfeaturecount = document.getElementById("commonFeatCount").innerHTML; 
		   var combine = (1*commonfeaturecount) + (1*selectfeatcount);
		
		  if (commonfeaturecount == -10) """),format.raw/*212.36*/("""{"""),format.raw/*212.37*/("""
    		
			"""),format.raw/*214.4*/("""}"""),format.raw/*214.5*/(""" else """),format.raw/*214.11*/("""{"""),format.raw/*214.12*/("""
  			
  			
  				for (i = selectfeatcount; i < combine; i++) """),format.raw/*217.51*/("""{"""),format.raw/*217.52*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "red";
		 array1.push(cars[i].value);
				"""),format.raw/*220.5*/("""}"""),format.raw/*220.6*/("""
  			
  			"""),format.raw/*222.6*/("""}"""),format.raw/*222.7*/("""
		  
		
		
		//The rest uncommon features
		
		  var Restfeatcount = document.getElementById("Restfeaturescount").innerHTML; 
		   var combine2 = (1*commonfeaturecount) + (1*selectfeatcount) + (1*Restfeatcount);
		
		  if (Restfeatcount == -10) """),format.raw/*231.31*/("""{"""),format.raw/*231.32*/("""
    		
			"""),format.raw/*233.4*/("""}"""),format.raw/*233.5*/(""" else """),format.raw/*233.11*/("""{"""),format.raw/*233.12*/("""
  			
  			
  				for (i = combine; i < combine2; i++) """),format.raw/*236.44*/("""{"""),format.raw/*236.45*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "green";
		 
				"""),format.raw/*239.5*/("""}"""),format.raw/*239.6*/("""
  			
  			"""),format.raw/*241.6*/("""}"""),format.raw/*241.7*/("""
		
		  document.getElementById("demo").innerHTML = combine2;
		  
		  
		  //found bee species colour
		  
		  var beeFcount = document.getElementById("demo2").innerHTML; 
		 // var beeCount = (beeFcount - 1);
		
		  if (beeFcount == -10) """),format.raw/*251.27*/("""{"""),format.raw/*251.28*/("""
    		
			"""),format.raw/*253.4*/("""}"""),format.raw/*253.5*/(""" else """),format.raw/*253.11*/("""{"""),format.raw/*253.12*/("""
  			
  			
  				for (i = 0; i < beeFcount; i++) """),format.raw/*256.39*/("""{"""),format.raw/*256.40*/(""" 
  				  document.getElementById("species").options.item(i).style.color = "blue";
		  var value = document.getElementById("species").options.item(i).value;
		  
		  if (value == "Plesianthidium_(Spinanthidium)_callescens_(Cockerell)_female" ||
		  value == "Plesianthidium_(Spinanthidium)_callescens_(Cockerell)_male" ||
		  value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_male" ||
		   value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_female")
		 """),format.raw/*264.4*/("""{"""),format.raw/*264.5*/("""
		 document.getElementById("images1").style.visibility = "visible"; 
		 """),format.raw/*266.4*/("""}"""),format.raw/*266.5*/("""
		 
		   if (value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_male" ||
		   value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_female")
		 """),format.raw/*270.4*/("""{"""),format.raw/*270.5*/("""
		 document.getElementById("images2").style.visibility = "visible"; 
		 """),format.raw/*272.4*/("""}"""),format.raw/*272.5*/("""
		 
				"""),format.raw/*274.5*/("""}"""),format.raw/*274.6*/("""
  			
  			"""),format.raw/*276.6*/("""}"""),format.raw/*276.7*/("""

	document.getElementById("tx").innerHTML = array1;
	document.getElementById("tx").select();
	
	//	var e = document.getElementById("demo2").innerHTML; 
	//	var ded = e-220;
		//document.getElementById("demo").innerHTML = "yes";
		//document.getElementById("cars").options.item(ded).style.color = "blue";
		  
		  </script>
   

""")))})))}
    }
    
    def render(message:String,messagef:String,count:Integer,beefoundcount:Integer,selectedfeatcount:Integer,features:List[String],selected:List[String],results:List[String],selectedElements:List[String],allFeatures:List[String],commonFeatCount:Integer,Restfeaturescount:Integer): play.api.templates.HtmlFormat.Appendable = apply(message,messagef,count,beefoundcount,selectedfeatcount,features,selected,results,selectedElements,allFeatures,commonFeatCount,Restfeaturescount)
    
    def f:((String,String,Integer,Integer,Integer,List[String],List[String],List[String],List[String],List[String],Integer,Integer) => play.api.templates.HtmlFormat.Appendable) = (message,messagef,count,beefoundcount,selectedfeatcount,features,selected,results,selectedElements,allFeatures,commonFeatCount,Restfeaturescount) => apply(message,messagef,count,beefoundcount,selectedfeatcount,features,selected,results,selectedElements,allFeatures,commonFeatCount,Restfeaturescount)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/viewboth.scala.html
                    HASH: 5051503b456e3dcfe8a4b2608344dee61851ba93
                    MATRIX: 890->1|1289->290|1317->309|1353->311|1407->357|1446->359|1631->508|1713->581|1753->583|1869->664|1922->701|1961->702|2025->730|2062->745|2117->764|2154->779|2202->796|2365->923|2394->930|2460->965|2629->1099|2719->1180|2759->1182|2877->1265|2929->1301|2968->1302|3029->1327|3065->1341|3120->1360|3156->1374|3203->1390|3336->1492|3747->1867|3778->1876|3895->1957|3910->1963|3959->1990|4298->2293|4313->2299|4362->2326|4997->2925|5054->2965|5094->2966|5164->2999|5205->3017|5260->3040|5344->3088|5398->3125|5438->3126|5502->3153|5540->3168|5590->3186|5784->3343|5820->3356|5884->3383|5924->3400|5994->3433|6032->3448|6104->3483|6144->3500|6235->3555|6297->3600|6337->3601|6407->3634|6453->3657|6508->3680|6976->4119|7006->4120|7045->4131|7074->4132|7109->4138|7139->4139|7225->4196|7255->4197|7402->4316|7431->4317|7471->4329|7500->4330|7762->4563|7792->4564|7831->4575|7860->4576|7895->4582|7925->4583|8017->4646|8047->4647|8189->4761|8218->4762|8258->4774|8287->4775|8562->5021|8592->5022|8631->5033|8660->5034|8695->5040|8725->5041|8810->5097|8840->5098|8957->5187|8986->5188|9026->5200|9055->5201|9324->5441|9354->5442|9393->5453|9422->5454|9457->5460|9487->5461|9567->5512|9597->5513|10097->5985|10126->5986|10227->6059|10256->6060|10444->6220|10473->6221|10574->6294|10603->6295|10640->6304|10669->6305|10709->6317|10738->6318
                    LINES: 26->1|32->3|34->6|35->7|35->7|35->7|44->16|44->16|44->16|48->20|48->20|48->20|50->22|50->22|50->22|50->22|52->24|60->32|60->32|63->35|73->45|73->45|73->45|77->49|77->49|77->49|79->51|79->51|79->51|79->51|81->53|88->60|104->76|104->76|109->81|109->81|109->81|118->90|118->90|118->90|155->127|155->127|155->127|158->130|158->130|161->133|168->140|168->140|168->140|171->143|171->143|174->146|185->157|185->157|186->158|186->158|187->159|187->159|188->160|188->160|194->166|194->166|194->166|197->169|197->169|200->172|222->194|222->194|224->196|224->196|224->196|224->196|227->199|227->199|230->202|230->202|232->204|232->204|240->212|240->212|242->214|242->214|242->214|242->214|245->217|245->217|248->220|248->220|250->222|250->222|259->231|259->231|261->233|261->233|261->233|261->233|264->236|264->236|267->239|267->239|269->241|269->241|279->251|279->251|281->253|281->253|281->253|281->253|284->256|284->256|292->264|292->264|294->266|294->266|298->270|298->270|300->272|300->272|302->274|302->274|304->276|304->276
                    -- GENERATED --
                */
            