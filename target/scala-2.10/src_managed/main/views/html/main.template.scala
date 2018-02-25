
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>"""),_display_(Seq[Any](/*10.17*/title)),format.raw/*10.22*/("""</title>
  
        <!-- Bootstrap -->
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Font Awesome -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <!-- Style Sheet -->
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*17.54*/routes/*17.60*/.Assets.at("stylesheets/main.css"))),format.raw/*17.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*18.59*/routes/*18.65*/.Assets.at("images/favicon.png"))),format.raw/*18.97*/("""">
        <!-- <script src=""""),_display_(Seq[Any](/*19.28*/routes/*19.34*/.Assets.at("javascripts/jquery-1.6.4.min.js"))),format.raw/*19.79*/("""" type="text/javascript"></script> -->
      <!-- Latest compiled and minified JavaScript -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
      

    </head>

    <body>
  

        <nav class="navbar navbar-default navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
              </button>
              <a class="navbar-brand" href=""""),_display_(Seq[Any](/*38.46*/routes/*38.52*/.Application.home)),format.raw/*38.69*/("""">"""),_display_(Seq[Any](/*38.72*/title)),format.raw/*38.77*/("""</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
              <li><a href=""""),_display_(Seq[Any](/*42.29*/routes/*42.35*/.ApplicationBoth.chooseBoth)),format.raw/*42.62*/("""">CLASSIFY and QUERY</a></li>
              
              
            </ul>
            </div>
          </div>
        </nav>

    <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fa fa-chevron-up"></i></button>


    <!--CONTAINER -->
    <div id="main-wrapper">
		
            """),_display_(Seq[Any](/*56.14*/content)),format.raw/*56.21*/("""
      
    </div>
    

 <!--FOOTER -->
<footer id="footer" class="site-footer" role="contentinfo">
  <section class="footer-wrap">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="footer-inner">
              <div class="site-info">
                <p> Web Ontology Classifier &copy;   
           <script type="text/javascript">
             document.write(new Date().getFullYear());
           </script>
            All Rights Reserved.
           </p>
              </div><!-- .site-info -->
            </div>
          </div>
        </div>
      </div>
    </section>
  </footer>
 <!--FOOTER -->

 <!--TO TOP BUTTON-->
<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() """),format.raw/*87.30*/("""{"""),format.raw/*87.31*/("""scrollFunction()"""),format.raw/*87.47*/("""}"""),format.raw/*87.48*/(""";

function scrollFunction() """),format.raw/*89.27*/("""{"""),format.raw/*89.28*/("""
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) """),format.raw/*90.82*/("""{"""),format.raw/*90.83*/("""
        document.getElementById("myBtn").style.display = "block";
    """),format.raw/*92.5*/("""}"""),format.raw/*92.6*/(""" else """),format.raw/*92.12*/("""{"""),format.raw/*92.13*/("""
        document.getElementById("myBtn").style.display = "none";
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""
"""),format.raw/*95.1*/("""}"""),format.raw/*95.2*/("""

// When the user clicks on the button, scroll to the top of the document
function topFunction() """),format.raw/*98.24*/("""{"""),format.raw/*98.25*/("""
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
"""),format.raw/*101.1*/("""}"""),format.raw/*101.2*/("""
</script>
<!--TO TOP BUTTON-->
     

    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Feb 25 11:58:23 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/main.scala.html
                    HASH: acf33d2c7674bbd720705f15860843eb39d266c8
                    MATRIX: 778->1|902->31|1173->266|1200->271|1826->861|1841->867|1897->901|1994->962|2009->968|2063->1000|2129->1030|2144->1036|2211->1081|3163->1997|3178->2003|3217->2020|3256->2023|3283->2028|3476->2185|3491->2191|3540->2218|3881->2523|3910->2530|4749->3341|4778->3342|4822->3358|4851->3359|4908->3388|4937->3389|5047->3471|5076->3472|5174->3543|5202->3544|5236->3550|5265->3551|5362->3621|5390->3622|5418->3623|5446->3624|5572->3722|5601->3723|5707->3801|5736->3802
                    LINES: 26->1|29->1|38->10|38->10|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|66->38|66->38|66->38|66->38|66->38|70->42|70->42|70->42|84->56|84->56|115->87|115->87|115->87|115->87|117->89|117->89|118->90|118->90|120->92|120->92|120->92|120->92|122->94|122->94|123->95|123->95|126->98|126->98|129->101|129->101
                    -- GENERATED --
                */
            