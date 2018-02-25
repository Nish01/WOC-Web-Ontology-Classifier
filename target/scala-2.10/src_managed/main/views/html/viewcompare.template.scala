
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
object viewcompare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[String,String,List[String],List[String],List[String],List[String],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, message2: String, elements: List[String], selected: List[String], allfeatures: List[String], commonfeatures: List[String], uncommonfeatures: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.174*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
   
      
       <div class="topdivone">
         <div class="leftelementtop">
         
        <h1 id="container">List of Taxa:</h1>
       
       
      """),_display_(Seq[Any](/*15.8*/form(action = routes.ApplicationCompare.getResults, args = 'id -> "carform")/*15.84*/ {_display_(Seq[Any](format.raw/*15.86*/("""  
      
		<select id="cars" name="cars" multiple="multiple" size="35">

		"""),_display_(Seq[Any](/*19.4*/for(index <- 0 until elements.size()) yield /*19.41*/{_display_(Seq[Any](format.raw/*19.42*/("""
		    
	<option value=""""),_display_(Seq[Any](/*21.18*/elements(index))),format.raw/*21.33*/("""" name="selected">"""),_display_(Seq[Any](/*21.52*/elements(index))),format.raw/*21.67*/("""</option>
		
		""")))})),format.raw/*23.4*/("""
		
      
      <p class="buttons">
         
             <input type="submit">
        <p>
      
      """)))})),format.raw/*31.8*/("""
      
      
		 </div>
     
      <div class="rightelementtop">

		<h1>Common Features</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*44.4*/for(index <- 0 until commonfeatures.size()) yield /*44.47*/{_display_(Seq[Any](format.raw/*44.48*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*47.15*/commonfeatures(index))),format.raw/*47.36*/("""</span>
			</li>
		
		""")))})),format.raw/*50.4*/("""
		
		</ul>
	  
     
		 </div>
     
      </div>
      
       <div class="topdiv">
    	  <div class="leftelement">

	   <h1>"""),_display_(Seq[Any](/*62.10*/(message))),format.raw/*62.19*/("""</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*68.4*/for(index <- 0 until selected.size()) yield /*68.41*/{_display_(Seq[Any](format.raw/*68.42*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*71.15*/selected(index))),format.raw/*71.30*/("""</span>
			</li>
		
		""")))})),format.raw/*74.4*/("""
		
		</ul>
		 </div>
		  <div class="middleelement">
		<h1>"""),_display_(Seq[Any](/*79.8*/(message2))),format.raw/*79.18*/("""</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*85.4*/for(index <- 0 until allfeatures.size()) yield /*85.44*/{_display_(Seq[Any](format.raw/*85.45*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*88.15*/allfeatures(index))),format.raw/*88.33*/("""</span>
			</li>
		
		""")))})),format.raw/*91.4*/("""
		
		</ul>
		 </div>
		  <div class="rightelement">
		  <h1>UnCommon Features</h1>
		
		<ul>

		"""),_display_(Seq[Any](/*100.4*/for(index <- 0 until uncommonfeatures.size()) yield /*100.49*/{_display_(Seq[Any](format.raw/*100.50*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*103.15*/uncommonfeatures(index))),format.raw/*103.38*/("""</span>
			</li>
		
		""")))})),format.raw/*106.4*/("""
		
		</ul>
		
		
		 </div>
		  </div>
   

""")))})))}
    }
    
    def render(message:String,message2:String,elements:List[String],selected:List[String],allfeatures:List[String],commonfeatures:List[String],uncommonfeatures:List[String]): play.api.templates.HtmlFormat.Appendable = apply(message,message2,elements,selected,allfeatures,commonfeatures,uncommonfeatures)
    
    def f:((String,String,List[String],List[String],List[String],List[String],List[String]) => play.api.templates.HtmlFormat.Appendable) = (message,message2,elements,selected,allfeatures,commonfeatures,uncommonfeatures) => apply(message,message2,elements,selected,allfeatures,commonfeatures,uncommonfeatures)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/viewcompare.scala.html
                    HASH: e5ad8d8e96f09b6191f7ae58fdec5507d81ead3f
                    MATRIX: 852->1|1135->173|1163->192|1199->194|1253->240|1292->242|1492->407|1577->483|1617->485|1729->562|1782->599|1821->600|1882->625|1919->640|1974->659|2011->674|2058->690|2197->798|2354->920|2413->963|2452->964|2521->997|2564->1018|2618->1041|2783->1170|2814->1179|2882->1212|2935->1249|2974->1250|3043->1283|3080->1298|3134->1321|3230->1382|3262->1392|3330->1425|3386->1465|3425->1466|3494->1499|3534->1517|3588->1540|3722->1638|3784->1683|3824->1684|3894->1717|3940->1740|3995->1763
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|43->15|43->15|43->15|47->19|47->19|47->19|49->21|49->21|49->21|49->21|51->23|59->31|72->44|72->44|72->44|75->47|75->47|78->50|90->62|90->62|96->68|96->68|96->68|99->71|99->71|102->74|107->79|107->79|113->85|113->85|113->85|116->88|116->88|119->91|128->100|128->100|128->100|131->103|131->103|134->106
                    -- GENERATED --
                */
            