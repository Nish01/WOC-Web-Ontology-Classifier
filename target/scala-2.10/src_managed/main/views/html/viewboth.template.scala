
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
"""),_display_(Seq[Any](/*7.2*/main(title = "Web Ontology Classifier")/*7.41*/ {_display_(Seq[Any](format.raw/*7.43*/("""
    
    
 <section class="Using">
		<div class="container">

			<div class="row">
				<div class="col-md-6">
		 			<h3 class="text-uppercase" id="container">Diagnostic Features:</h3>
     		 			"""),_display_(Seq[Any](/*16.13*/form(action = routes.ApplicationBoth.getResults, args = 'id -> "carform")/*16.86*/ {_display_(Seq[Any](format.raw/*16.88*/("""  
      
							<select id="cars" name="cars" multiple="multiple" size="40" style="max-width:100%">
							"""),_display_(Seq[Any](/*19.9*/for(index <- 0 until features.size()) yield /*19.46*/{_display_(Seq[Any](format.raw/*19.47*/("""
		   					<option value=""""),_display_(Seq[Any](/*20.27*/features(index))),format.raw/*20.42*/("""" name="selected">"""),_display_(Seq[Any](/*20.61*/features(index))),format.raw/*20.76*/("""</option>
							""")))})),format.raw/*21.9*/("""
      
      				<p><br>
             			<input class="btn btn-success" type="submit">
      				</p>
        
			       	<p>
			         Count: """),_display_(Seq[Any](/*28.21*/(count))),format.raw/*28.28*/("""            
			        </p>
      					""")))})),format.raw/*30.13*/("""
		 		</div>

		 		<div class="col-md-6">
		 			<h3  class="text-uppercase" id="container">Elements:</h3>   
				      """),_display_(Seq[Any](/*35.12*/form(action = routes.ApplicationBoth.getResultsBoth, args = 'id -> "speciesform")/*35.93*/ {_display_(Seq[Any](format.raw/*35.95*/("""  
						<select id="species" name="species" multiple="multiple" size="40" style="max-width:100%">
							"""),_display_(Seq[Any](/*37.9*/for(index <- 0 until results.size()) yield /*37.45*/{_display_(Seq[Any](format.raw/*37.46*/("""
						   <option value=""""),_display_(Seq[Any](/*38.26*/results(index))),format.raw/*38.40*/("""" name="selected">"""),_display_(Seq[Any](/*38.59*/results(index))),format.raw/*38.73*/("""</option>
							""")))})),format.raw/*39.9*/("""
							
				   	   		<p>		<br>	         
				             <input class="btn btn-success" type="submit">
				    	  	</p>
				       
				     """)))})),format.raw/*45.11*/("""
		 		</div>
			</div>	

			<div class="row">
				<div class="col-md-6">
					<h4 class="text-uppercase">Full Description:</h4>
					<textarea id="tx" rows="3" cols="50" placeholder="The Elements Full Description"></textarea><br>
					<!-- <input type="text" id="tx" name="tx"> -->
					<button type="button" class="btn btn-info" id="copyAll" onclick="selectAll()">Select All</button>
				</div>
				<div class="col-md-6">
					<h4 class="text-uppercase">Colour Identification Key:</h4>
					<ul>				    
						<li>
						    <span class="bluekey">Selected/Common Features | Selected/Found Elements</span>	
						</li>						
						<li>
						   <span class="redkey"> Common Features </span>
						</li>
						<li>
							<span class="greenkey">Uncommon features to found elements </span>			
						</li>			
					</ul>
			 		 <button type="button" class="btn btn-info" data-toggle="modal" data-target="#keyInfo">Key Info</button>

			 		 <!-- Modal -->
					  <div class="modal fade" id="keyInfo" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="text-uppercase modal-title">Colour Identification Key:</h4>
					        </div>
					        <div class="modal-body">
						    <ul>				    
								<li>
								    <span class="bluekey">Blue: </span>Represents the selected/common Features to the found Elements OR the selected/found Elements (in the Elements List).	
								</li>						
								<li>
								   <span class="redkey">Red:</span> Represents all the Elements' common features.
								</li>
								<li>
									<span class="greenkey">Green:</span> Represents all uncommon features to the found elements. 		
								</li>			
							</ul>
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					      
					    </div>
				</div>

					<!-- HIDEN STUFF -->
					<div hidden>	
					 <h1>All Features</h1>
						<ul>
						"""),_display_(Seq[Any](/*106.8*/for(index <- 0 until allFeatures.size()) yield /*106.48*/{_display_(Seq[Any](format.raw/*106.49*/("""						    
						    <li>
						    	<span>"""),_display_(Seq[Any](/*108.19*/allFeatures(index))),format.raw/*108.37*/("""</span>
							</li>						
						""")))})),format.raw/*110.8*/("""						
						</ul>												
						<h1>Test</h1>				      
				      	"""),_display_(Seq[Any](/*113.13*/for(index <- 0 until selected.size()) yield /*113.50*/{_display_(Seq[Any](format.raw/*113.51*/("""					  
						    	<span>"""),_display_(Seq[Any](/*114.19*/selected(index))),format.raw/*114.34*/("""</span>	
						""")))})),format.raw/*115.8*/("""
						 
						<h1>Common Features</h1>
				      
				 		<p id="demo"></p>
				 		<p id="demo2">"""),_display_(Seq[Any](/*120.23*/beefoundcount)),format.raw/*120.36*/("""</p>
				 		<p id="featcount">"""),_display_(Seq[Any](/*121.27*/selectedfeatcount)),format.raw/*121.44*/("""</p>
				 		<p id="commonFeatCount">"""),_display_(Seq[Any](/*122.33*/commonFeatCount)),format.raw/*122.48*/("""</p>
				 		<p id="Restfeaturescount">"""),_display_(Seq[Any](/*123.35*/Restfeaturescount)),format.raw/*123.52*/("""</p>
	 		
				 		<h1>Selected Elements:</h1>
						<ul>

						"""),_display_(Seq[Any](/*128.8*/for(index <- 0 until selectedElements.size()) yield /*128.53*/{_display_(Seq[Any](format.raw/*128.54*/("""						    
						    <li>
						    	<span>"""),_display_(Seq[Any](/*130.19*/selectedElements(index))),format.raw/*130.42*/("""</span>
							</li>						
						""")))})),format.raw/*132.8*/("""						
						</ul>
						</div>

			</div>		


		</div>
</section>




    
 		
 		<!-- <h1>"""),_display_(Seq[Any](/*147.14*/(message))),format.raw/*147.23*/("""</h1>
		 
		
		 <p id="images1" style="visibility: hidden;">
		
		  <img src=""""),_display_(Seq[Any](/*152.16*/routes/*152.22*/.Assets.at("images/21.jpg"))),format.raw/*152.49*/("""" alt="Known distribution of 
		  Plesianthidium calescens and Plesianthidium richtersveldi" height="228" width="187">
		  <br>
		 Known distribution of 
		  Plesianthidium calescens and Plesianthidium richtersveldi.
		 </p>
		 
    	<p id="images2" style="visibility: hidden;">
    	
      	<img src=""""),_display_(Seq[Any](/*161.19*/routes/*161.25*/.Assets.at("images/22.jpg"))),format.raw/*161.52*/("""" alt="Plesianthidium richtersveldi. a. 
     	 Female habitus. b. Female face. c. Male habitus. d. Male face" height="234" width="283">
     	<br>
     	Plesianthidium richtersveldi. a. 
     	Female habitus. b. Female face. c. Male habitus. d. Male face.
		 
    
   
		    </p>
	
  
  
  
  
       <div class="topdiv">
    	  <div class="leftelement">
    	  
    	  
		
	  
		 </div>
		 

		  -->
		   
		  
 <script>
		  
		  // document.getElementById("bluekey").style.color = "blue";
		  // document.getElementById("redkey").style.color = "red";
		  // document.getElementById("greenkey").style.color = "green";
		  
		  
		  var array1 = new Array();
  
			  //selected features colour
		  
		   var selectfeatcount = document.getElementById("featcount").innerHTML; 
		
		  if (selectfeatcount == -10) """),format.raw/*200.33*/("""{"""),format.raw/*200.34*/("""
    		
			"""),format.raw/*202.4*/("""}"""),format.raw/*202.5*/(""" else """),format.raw/*202.11*/("""{"""),format.raw/*202.12*/("""
  			
  			
  				for (i = 0; i < selectfeatcount; i++) """),format.raw/*205.45*/("""{"""),format.raw/*205.46*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "blue";
		 			 array1.push(cars[i].value);
				"""),format.raw/*208.5*/("""}"""),format.raw/*208.6*/("""
  			
  			"""),format.raw/*210.6*/("""}"""),format.raw/*210.7*/("""
		  
		  
		  //common features colour
		  
		   var commonfeaturecount = document.getElementById("commonFeatCount").innerHTML; 
		   var combine = (1*commonfeaturecount) + (1*selectfeatcount);
		
		  if (commonfeaturecount == -10) """),format.raw/*218.36*/("""{"""),format.raw/*218.37*/("""
    		
			"""),format.raw/*220.4*/("""}"""),format.raw/*220.5*/(""" else """),format.raw/*220.11*/("""{"""),format.raw/*220.12*/("""
  			
  			
  				for (i = selectfeatcount; i < combine; i++) """),format.raw/*223.51*/("""{"""),format.raw/*223.52*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "red";
		 array1.push(cars[i].value);
				"""),format.raw/*226.5*/("""}"""),format.raw/*226.6*/("""
  			
  			"""),format.raw/*228.6*/("""}"""),format.raw/*228.7*/("""
		  
		
		
		//The rest uncommon features
		
		  var Restfeatcount = document.getElementById("Restfeaturescount").innerHTML; 
		   var combine2 = (1*commonfeaturecount) + (1*selectfeatcount) + (1*Restfeatcount);
		
		  if (Restfeatcount == -10) """),format.raw/*237.31*/("""{"""),format.raw/*237.32*/("""
    		
			"""),format.raw/*239.4*/("""}"""),format.raw/*239.5*/(""" else """),format.raw/*239.11*/("""{"""),format.raw/*239.12*/("""
  			
  			
  				for (i = combine; i < combine2; i++) """),format.raw/*242.44*/("""{"""),format.raw/*242.45*/(""" 
  				  document.getElementById("cars").options.item(i).style.color = "green";
		 
				"""),format.raw/*245.5*/("""}"""),format.raw/*245.6*/("""
  			
  			"""),format.raw/*247.6*/("""}"""),format.raw/*247.7*/("""
		
		  document.getElementById("demo").innerHTML = combine2;
		  
		  
		  //found bee species colour
		  
		  var beeFcount = document.getElementById("demo2").innerHTML; 
		 // var beeCount = (beeFcount - 1);
		
		  if (beeFcount == -10) """),format.raw/*257.27*/("""{"""),format.raw/*257.28*/("""
    		
			"""),format.raw/*259.4*/("""}"""),format.raw/*259.5*/(""" else """),format.raw/*259.11*/("""{"""),format.raw/*259.12*/("""
  			
  			
  				for (i = 0; i < beeFcount; i++) """),format.raw/*262.39*/("""{"""),format.raw/*262.40*/(""" 
  				  document.getElementById("species").options.item(i).style.color = "blue";
		//   var value = document.getElementById("species").options.item(i).value;
		  
		//   if (value == "Plesianthidium_(Spinanthidium)_callescens_(Cockerell)_female" ||
		//   value == "Plesianthidium_(Spinanthidium)_callescens_(Cockerell)_male" ||
		//   value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_male" ||
		//    value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_female")
		//  """),format.raw/*270.7*/("""{"""),format.raw/*270.8*/("""
		// // document.getElementById("images1").style.visibility = "visible"; 
		//  """),format.raw/*272.7*/("""}"""),format.raw/*272.8*/("""
		 
		//    if (value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_male" ||
		//    value == "Plesianthidium_(Spinanthidium)_richtersveldi_sp.n_female")
		//  """),format.raw/*276.7*/("""{"""),format.raw/*276.8*/("""
		//  //document.getElementById("images2").style.visibility = "visible"; 
		//  """),format.raw/*278.7*/("""}"""),format.raw/*278.8*/("""
		 
				"""),format.raw/*280.5*/("""}"""),format.raw/*280.6*/("""
  			
  			"""),format.raw/*282.6*/("""}"""),format.raw/*282.7*/("""

	document.getElementById("tx").innerHTML = array1;
	//document.getElementById("tx").select();
	
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
                    DATE: Sun Mar 04 14:03:51 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/viewboth.scala.html
                    HASH: b89eb3b0dbd566c1d6ab27ba5a4711429cb23e39
                    MATRIX: 890->1|1289->290|1317->309|1353->311|1400->350|1439->352|1672->549|1754->622|1794->624|1938->733|1991->770|2030->771|2093->798|2130->813|2185->832|2222->847|2271->865|2454->1012|2483->1019|2556->1060|2712->1180|2802->1261|2842->1263|2984->1370|3036->1406|3075->1407|3137->1433|3173->1447|3228->1466|3264->1480|3313->1498|3489->1642|5738->3855|5795->3895|5835->3896|5916->3940|5957->3958|6023->3992|6133->4065|6187->4102|6227->4103|6290->4129|6328->4144|6376->4160|6511->4258|6547->4271|6615->4302|6655->4319|6729->4356|6767->4371|6843->4410|6883->4427|6983->4491|7045->4536|7085->4537|7166->4581|7212->4604|7278->4638|7408->4731|7440->4740|7556->4819|7572->4825|7622->4852|7962->5155|7978->5161|8028->5188|8868->5999|8898->6000|8937->6011|8966->6012|9001->6018|9031->6019|9117->6076|9147->6077|9294->6196|9323->6197|9363->6209|9392->6210|9654->6443|9684->6444|9723->6455|9752->6456|9787->6462|9817->6463|9909->6526|9939->6527|10081->6641|10110->6642|10150->6654|10179->6655|10454->6901|10484->6902|10523->6913|10552->6914|10587->6920|10617->6921|10702->6977|10732->6978|10849->7067|10878->7068|10918->7080|10947->7081|11216->7321|11246->7322|11285->7333|11314->7334|11349->7340|11379->7341|11459->7392|11489->7393|12007->7883|12036->7884|12145->7965|12174->7966|12371->8135|12400->8136|12509->8217|12538->8218|12575->8227|12604->8228|12644->8240|12673->8241
                    LINES: 26->1|32->3|34->6|35->7|35->7|35->7|44->16|44->16|44->16|47->19|47->19|47->19|48->20|48->20|48->20|48->20|49->21|56->28|56->28|58->30|63->35|63->35|63->35|65->37|65->37|65->37|66->38|66->38|66->38|66->38|67->39|73->45|134->106|134->106|134->106|136->108|136->108|138->110|141->113|141->113|141->113|142->114|142->114|143->115|148->120|148->120|149->121|149->121|150->122|150->122|151->123|151->123|156->128|156->128|156->128|158->130|158->130|160->132|175->147|175->147|180->152|180->152|180->152|189->161|189->161|189->161|228->200|228->200|230->202|230->202|230->202|230->202|233->205|233->205|236->208|236->208|238->210|238->210|246->218|246->218|248->220|248->220|248->220|248->220|251->223|251->223|254->226|254->226|256->228|256->228|265->237|265->237|267->239|267->239|267->239|267->239|270->242|270->242|273->245|273->245|275->247|275->247|285->257|285->257|287->259|287->259|287->259|287->259|290->262|290->262|298->270|298->270|300->272|300->272|304->276|304->276|306->278|306->278|308->280|308->280|310->282|310->282
                    -- GENERATED --
                */
            