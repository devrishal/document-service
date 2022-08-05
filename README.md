# barcode-generator

Project to generate Barcode

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

<h3 align="left">Languages and Tools:</h3>
<p align="left">    
   <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> &nbsp;&nbsp;&nbsp;
   <a href="https://spring.io/" target="_blank" rel="noreferrer"> 
   <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> &nbsp;&nbsp;&nbsp;
   </a> 
    <a href="http://barcode4j.sourceforge.net/" target="_blank" rel="noreferrer" ><img src="http://barcode4j.sourceforge.net/resources/images/barcode4j-logo.gif" width="80" height="40"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://xmlgraphics.apache.org/fop/1.1/graphics.html" target="_blank" rel="noreferrer" ><img src="https://xmlgraphics.apache.org/images/apache-fop-logo.jpg" width="80" height="40"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
<svg focusable="false" class="pdfbox-brand-text" xmlns="http://www.w3.org/2000/svg" style="isolation:isolate" viewBox="0 0 109.81066666651577 30.943999999957384" aria-labelledby="brandTextTitle brandTextDesc" role="img">
  <title id="brandTextTitle">PDFBox brand text</title>
  <desc id="brandTextDesc">PDFBox, the brand text.</desc>
  <path d="M0 .31h6.528q1.792 0 3.157.47 1.366.468 2.475 1.663 1.11 1.194 1.536 2.816.427 1.57.427 4.3 0 2-.256 3.45-.214 1.41-.982 2.64-.896 1.492-2.39 2.345-1.492.81-3.924.81H4.36v11.87H0V.305zm4.352 14.42h2.09q1.323 0 2.05-.383.724-.384 1.065-1.024.342-.683.384-1.622.09-.93.09-2.09 0-1.06-.08-2-.04-.98-.38-1.66-.3-.72-.98-1.11-.68-.43-1.96-.43H4.36v10.32z" fill-rule="evenodd"></path>
  <path d="M17.333.31h6.443q3.712 0 5.675 2.09 1.97 2.048 1.97 5.76v14.208q0 4.267-2.09 6.315-2.05 2.005-5.93 2.005h-6.06V.308zm4.352 26.282h2.006q1.84 0 2.61-.896.77-.94.77-2.9V8.16q0-1.792-.72-2.773-.72-.982-2.64-.982H21.7v22.187z" fill-rule="evenodd"></path>
  <path d="M35.583.31h12.97v4.095h-8.618v9.216h7.51v4.1h-7.51v12.97h-4.352V.31z"></path>
  <path d="M51.417.31h6.357q2.09 0 3.54.64 1.495.64 2.433 1.706.94 1.067 1.323 2.475.427 1.37.427 2.86V9.1q0 1.236-.214 2.09-.17.853-.554 1.493-.39.64-.94 1.152-.56.47-1.28.896 1.53.73 2.26 2.18.72 1.41.72 3.8v1.71q0 4.01-1.97 6.15-1.92 2.13-6.19 2.13H51.4V.31zm4.352 26.026h1.87q1.32 0 2.05-.384.77-.384 1.15-1.067.38-.682.47-1.62.08-.94.08-2.05 0-1.15-.13-2.004-.13-.85-.56-1.4-.386-.6-1.11-.89-.727-.3-1.92-.3h-1.92v9.73zm0-13.568h1.96q2.17 0 2.9-1.067.77-1.1.77-3.2 0-2.04-.86-3.07-.81-1.02-2.99-1.02h-1.79v8.37z" fill-rule="evenodd"></path>
  <path d="M69.027 16.31q0-1.323.17-2.433.17-1.11.64-1.962.768-1.408 2.22-2.262 1.45-.853 3.455-.853t3.456.853q1.45.854 2.22 2.262.468.853.64 1.962.17 1.11.17 2.432v7.12q0 1.32-.17 2.43-.172 1.11-.64 1.96-.77 1.4-2.22 2.26-1.45.85-3.456.85-2.005 0-3.456-.86-1.45-.854-2.22-2.26-.468-.855-.64-1.964-.17-1.11-.17-2.43V16.3zm4.352 7.807q0 1.238.55 1.878.6.597 1.58.597.98 0 1.53-.597.59-.64.59-1.878v-8.49q0-1.238-.6-1.835-.557-.64-1.538-.64-.98 0-1.58.64-.553.597-.553 1.835v8.49z" fill-rule="evenodd"></path>
  <path d="M88.316 19.637L83.24 9.057h4.607l2.688 6.143 2.688-6.144h4.608l-5.16 10.58 5.42 11.052h-4.61l-2.94-6.613-2.94 6.613h-4.61l5.34-11.05z"></path>
  <path d="M102.883 5.28h1.2q.784 0 1.168-.224.4-.24.4-.784 0-.464-.35-.672-.33-.224-.88-.224h-1.53V5.28zm-1.056-2.864h2.56q2.32 0 2.32 1.904 0 .48-.144.816-.128.336-.368.56-.24.224-.56.352-.304.112-.656.16l1.93 2.96h-1.28L103.7 6.24h-.817v2.928h-1.056V2.416zm6.832 3.376q0-.976-.37-1.84-.37-.864-.99-1.504-.63-.64-1.48-1.008-.85-.384-1.81-.384t-1.81.384q-.85.368-1.47 1.008t-1 1.504-.37 1.84q0 .976.364 1.84.37.864.992 1.504t1.47 1.024q.85.368 1.81.368.96 0 1.805-.368.85-.384 1.47-1.024.625-.64.99-1.504.37-.864.37-1.84zm-10.44 0q0-1.2.45-2.256.46-1.056 1.25-1.84t1.84-1.232Q102.82 0 104.02 0t2.255.464q1.056.448 1.84 1.232t1.232 1.84q.464 1.056.464 2.256 0 1.2-.46 2.256-.45 1.056-1.23 1.84t-1.84 1.248q-1.05.448-2.25.448t-2.25-.448q-1.053-.464-1.84-1.248t-1.25-1.84q-.45-1.056-.45-2.256z" fill-rule="evenodd"></path>
</svg>
</p>

##### Current Version- 1.0.0

## Usage

Steps to setup the application in your local:

1) Clone the repository or download it.
2) Import it using maven project.
3) Run the application using Run command.
4) The swagger Api url can be accessed at http://localhost:8080/document-service/swagger-ui/index.html

