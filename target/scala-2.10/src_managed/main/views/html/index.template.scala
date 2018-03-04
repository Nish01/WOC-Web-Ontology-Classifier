
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <section class="jumbotron">
	<div class="container">

	<div class="bs-example-bg-classes hidden">
	<p id = "error" class="bg-info"><i>"""),_display_(Seq[Any](/*11.38*/(message))),format.raw/*11.47*/("""</i></p>
	</div>

     <h2>The Bee Genus Plesianthidium Cameron</h2>
     

     <p>
     The southern African bee genus iPlesianthidium Cameron is revised. It comprises twelve species. 
     Two new species were described, namely Plesianthidium (Spinanthidium) richtersveldensis and 
     Plesianthidium (Spinanthidium) namaquaensis. Two species names have been removed from synonymy 
     with volkmanni; namely calvini and rufocaudatum that are here considered to be valid species. 
     Keys for the identification of the species of Plesianthidium is given.
	</p>
	

	<p id="keywords">
	<b>Key words:</b> Afrotropical, pollinator, pollen collector, southern Africa
     
    </p>  
         <br>
			    <div class="row">
				    <div class="col-md-12 col-md-offset-1">
		 			<img src=""""),_display_(Seq[Any](/*33.18*/routes/*33.24*/.Assets.at("images/im.jpg"))),format.raw/*33.51*/("""" alt="Bee Genus"  height="459" width="459">
		    	<!-- 	</div>
 					<div class="col-md-6"> -->
		 			<img src=""""),_display_(Seq[Any](/*36.18*/routes/*36.24*/.Assets.at("images/b.jpg"))),format.raw/*36.50*/("""" alt="Bee Genus" height="459" width="459">
		    		</div>

				</div>	
    
</div>
</section>

<section class="Using">
<div class="container">
    <h3>Using The Application:</h3>
    
   
   		
   
	   
	    <p>This application allows you to load and classify an ontology (subjected to our specific ontology modeling 'hooks')
	    and perform certain classification queries over the ontology.	    <br>
	        <br>
	  By clicking the link 'CLASSIFY and QUERY' in the menu bar, you will be directed to an upload page. Browse for your ontology 
	  and select it to upload. <br> <br> 
	  It will now classify the ontology or tell you that the file is of an incorrect format if not a .owl file. <br>
	  *Please be patient as some large ontologies may take a few minutes to classify.
	  <br>
	 <br>
	 Once classified a page will load with the ontology data. The first column will consist of the Diagnostic Features
	 and the right column will list the Elements which are associated with some diagnostic features.
	    <br> <br> 
	 Make a selection from one of the columns and click the respective Submit button to query the ontology.  
	   
	    
	    </p>
  

    <p><b>Disclaimer:</b> Please be aware that this application is still in its testing stages and can still be subject to errors.</P>
    
</div>
</section>
    
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 02 23:12:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/index.scala.html
                    HASH: be28dfa29810c928e0b80c4a37013afeeef543c7
                    MATRIX: 774->1|901->18|929->37|965->39|1019->85|1058->87|1239->232|1270->241|2096->1031|2111->1037|2160->1064|2311->1179|2326->1185|2374->1211
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|61->33|61->33|61->33|64->36|64->36|64->36
                    -- GENERATED --
                */
            