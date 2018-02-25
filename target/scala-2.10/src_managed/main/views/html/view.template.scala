
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
object view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,Integer,List[String],List[String],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, messagef: String, count: Integer, features: List[String], selected: List[String], results: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
     <div class="topdiv">
    	  <div class="leftelement">
    
    <h1 id="container">Diagnostic Features:</h1>
      
      
      """),_display_(Seq[Any](/*13.8*/form(action = routes.Application.getResults, args = 'id -> "carform")/*13.77*/ {_display_(Seq[Any](format.raw/*13.79*/("""  
      
		<select id="cars" name="cars" multiple="multiple" size="40">

		"""),_display_(Seq[Any](/*17.4*/for(index <- 0 until features.size()) yield /*17.41*/{_display_(Seq[Any](format.raw/*17.42*/("""
		    
	<option value=""""),_display_(Seq[Any](/*19.18*/features(index))),format.raw/*19.33*/("""" name="selected">"""),_display_(Seq[Any](/*19.52*/features(index))),format.raw/*19.67*/("""</option>
		
		""")))})),format.raw/*21.4*/("""
		
		
		
      
      <p class="buttons">
         
             <input type="submit">
        <p>
        
       <p>
         Count: """),_display_(Seq[Any](/*32.18*/(count))),format.raw/*32.25*/("""
             
        <p>
      """)))})),format.raw/*35.8*/("""
      
      
      </div>
      
    <div class="middleelement">
      <h1>"""),_display_(Seq[Any](/*41.12*/(message))),format.raw/*41.21*/("""</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*47.4*/for(index <- 0 until selected.size()) yield /*47.41*/{_display_(Seq[Any](format.raw/*47.42*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*50.15*/selected(index))),format.raw/*50.30*/("""</span>
			</li>
		
		""")))})),format.raw/*53.4*/("""
		
		</ul>
		</div>
		 
      <div class="rightelement">
		    <h1>"""),_display_(Seq[Any](/*59.12*/(messagef))),format.raw/*59.22*/("""</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*65.4*/for(index <- 0 until results.size()) yield /*65.40*/{_display_(Seq[Any](format.raw/*65.41*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*68.15*/results(index))),format.raw/*68.29*/("""</span>
			</li>
		
		""")))})),format.raw/*71.4*/("""
		
		</ul>
         
   </div>
   </div>

""")))})))}
    }
    
    def render(message:String,messagef:String,count:Integer,features:List[String],selected:List[String],results:List[String]): play.api.templates.HtmlFormat.Appendable = apply(message,messagef,count,features,selected,results)
    
    def f:((String,String,Integer,List[String],List[String],List[String]) => play.api.templates.HtmlFormat.Appendable) = (message,messagef,count,features,selected,results) => apply(message,messagef,count,features,selected,results)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/view.scala.html
                    HASH: abada38d0a4adf6e54794ba07b87b3124853c4a3
                    MATRIX: 827->1|1060->123|1088->142|1124->144|1178->190|1217->192|1392->332|1470->401|1510->403|1622->480|1675->517|1714->518|1775->543|1812->558|1867->577|1904->592|1951->608|2124->745|2153->752|2218->786|2332->864|2363->873|2431->906|2484->943|2523->944|2592->977|2629->992|2683->1015|2788->1084|2820->1094|2888->1127|2940->1163|2979->1164|3048->1197|3084->1211|3138->1234
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|41->13|41->13|41->13|45->17|45->17|45->17|47->19|47->19|47->19|47->19|49->21|60->32|60->32|63->35|69->41|69->41|75->47|75->47|75->47|78->50|78->50|81->53|87->59|87->59|93->65|93->65|93->65|96->68|96->68|99->71
                    -- GENERATED --
                */
            