
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
object viewelements extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,List[String],List[String],List[String],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, elements: List[String], selected: List[String], allfeatures: List[String], commonfeatures: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <h1 id="container">List of Taxa:</h1>
      
      
      """),_display_(Seq[Any](/*10.8*/form(action = routes.ApplicationReverse.getResults, args = 'id -> "carform")/*10.84*/ {_display_(Seq[Any](format.raw/*10.86*/("""  
      
		<select id="cars" name="cars" multiple="multiple" size="35">

		"""),_display_(Seq[Any](/*14.4*/for(index <- 0 until elements.size()) yield /*14.41*/{_display_(Seq[Any](format.raw/*14.42*/("""
		    
	<option value=""""),_display_(Seq[Any](/*16.18*/elements(index))),format.raw/*16.33*/("""" name="selected">"""),_display_(Seq[Any](/*16.52*/elements(index))),format.raw/*16.67*/("""</option>
		
		""")))})),format.raw/*18.4*/("""
		
      
      <p class="buttons">
         
             <input type="submit">
        <p>
      
      """)))})),format.raw/*26.8*/("""
       <div class="topdiv">
    	  <div class="leftelement">

	   <h1>"""),_display_(Seq[Any](/*30.10*/(message))),format.raw/*30.19*/("""</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*36.4*/for(index <- 0 until selected.size()) yield /*36.41*/{_display_(Seq[Any](format.raw/*36.42*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*39.15*/selected(index))),format.raw/*39.30*/("""</span>
			</li>
		
		""")))})),format.raw/*42.4*/("""
		
		</ul>
		 </div>
		  <div class="middleelement">
		<h1>All Features</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*53.4*/for(index <- 0 until allfeatures.size()) yield /*53.44*/{_display_(Seq[Any](format.raw/*53.45*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*56.15*/allfeatures(index))),format.raw/*56.33*/("""</span>
			</li>
		
		""")))})),format.raw/*59.4*/("""
		
		</ul>
		 </div>
		  <div class="rightelement">
		 
		<h1>Common Features</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*71.4*/for(index <- 0 until commonfeatures.size()) yield /*71.47*/{_display_(Seq[Any](format.raw/*71.48*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*74.15*/commonfeatures(index))),format.raw/*74.36*/("""</span>
			</li>
		
		""")))})),format.raw/*77.4*/("""
		
		</ul>
		 </div>
		  </div>


<script>

function myFunction()
"""),format.raw/*87.1*/("""{"""),format.raw/*87.2*/("""

 //console.log("your message here");

 var InvForm = document.forms.carform;
     var arr = new Array();
    
     var x = 0;
    
     for (x=0;x<InvForm.cars.length;x++)
         """),format.raw/*97.10*/("""{"""),format.raw/*97.11*/("""
            if(InvForm.cars[x].selected)
            """),format.raw/*99.13*/("""{"""),format.raw/*99.14*/("""
         
             arr.push(InvForm.cars[x].value);
    	
            """),format.raw/*103.13*/("""}"""),format.raw/*103.14*/("""
         """),format.raw/*104.10*/("""}"""),format.raw/*104.11*/("""
   //alert(arr);
   


"""),format.raw/*109.1*/("""}"""),format.raw/*109.2*/("""

</script>
      
         
   

""")))})))}
    }
    
    def render(message:String,elements:List[String],selected:List[String],allfeatures:List[String],commonfeatures:List[String]): play.api.templates.HtmlFormat.Appendable = apply(message,elements,selected,allfeatures,commonfeatures)
    
    def f:((String,List[String],List[String],List[String],List[String]) => play.api.templates.HtmlFormat.Appendable) = (message,elements,selected,allfeatures,commonfeatures) => apply(message,elements,selected,allfeatures,commonfeatures)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/viewelements.scala.html
                    HASH: d0505492f26b4c125c753dc65c4e2881aef2b4d2
                    MATRIX: 833->1|1066->123|1094->142|1130->144|1184->190|1223->192|1327->261|1412->337|1452->339|1564->416|1617->453|1656->454|1717->479|1754->494|1809->513|1846->528|1893->544|2032->652|2140->724|2171->733|2239->766|2292->803|2331->804|2400->837|2437->852|2491->875|2631->980|2687->1020|2726->1021|2795->1054|2835->1072|2889->1095|3035->1206|3094->1249|3133->1250|3202->1283|3245->1304|3299->1327|3393->1394|3421->1395|3632->1578|3661->1579|3743->1633|3772->1634|3876->1709|3906->1710|3945->1720|3975->1721|4027->1745|4056->1746
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|38->10|38->10|38->10|42->14|42->14|42->14|44->16|44->16|44->16|44->16|46->18|54->26|58->30|58->30|64->36|64->36|64->36|67->39|67->39|70->42|81->53|81->53|81->53|84->56|84->56|87->59|99->71|99->71|99->71|102->74|102->74|105->77|115->87|115->87|125->97|125->97|127->99|127->99|131->103|131->103|132->104|132->104|137->109|137->109
                    -- GENERATED --
                */
            