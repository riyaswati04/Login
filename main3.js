//var pageCounter = 1;
//var animalContainer = document.getElementById("animal-info");
var btn = document.getElementById("bn");
var btn2 = document.getElementById("bn2");
var elem=document.getElementById("title");
var elem1=document.getElementById("ti");
//var elem3=document.getElementById("no");
//window.console.log(elem3.value);

var json ={};
btn.addEventListener("click", function() {
  var ourRequest = new XMLHttpRequest();
  //makeRequest();
  ourRequest.open('GET', 'http://localhost:8080/login/Connect?t='+elem.value);
  ourRequest.onload = function() {
    //console.log(ourRequest.responseText);
      var ourData = JSON.parse(ourRequest.responseText);
     //window.console.log(ourData[0]);
       generate_table(ourData);
     
    };
    ourRequest.send();
 
  });

btn2.addEventListener("click", function() {
	  var ourRequest = new XMLHttpRequest();
	  //makeRequest();
	  ourRequest.open('GET', 'http://localhost:8080/login/Connect1?t='+elem1.value);
	  ourRequest.onload = function() {
	    //console.log(ourRequest.responseText);
	      var ourData = JSON.parse(ourRequest.responseText);
	     //window.console.log(ourData[0]);
	       append_table(ourData);
	     
	    };
	    ourRequest.send();
	 
	  });

function generate_table(ourData) {
	  // get the reference for the b ody
          window.console.log(ourData);
	  var body = document.getElementsByTagName("body")[0];
	 
	  // creates a <table> element and a <tbody> element
	  var tbl = document.createElement("table");
	  tbl.id="ta";
	  var tblBody = document.createElement("tbody");
	  tblBody.id="tab";

	  tbl.classList.add("table-striped");
	  tbl.classList.add("table");
	  tbl.classList.add("table-bordered");

	  
	  
	 var row = document.createElement("tr");
	  var cell = document.createElement("th");
      var cellText = document.createTextNode("Title");
      cell.appendChild(cellText);
      row.appendChild(cell);
      var cell = document.createElement("th");
      var cellText = document.createTextNode("Year");
      cell.appendChild(cellText);
      row.appendChild(cell);
      var cell = document.createElement("th");
      var cellText = document.createTextNode("imdbID");
      cell.appendChild(cellText);
      row.appendChild(cell);
      var cell = document.createElement("th");
      var cellText = document.createTextNode("Type");
      cell.appendChild(cellText);
      row.appendChild(cell);
      var cell = document.createElement("th");
      var cellText = document.createTextNode("Poster");
      cell.appendChild(cellText);
      row.appendChild(cell);
      tblBody.appendChild(row);
	  
      var cell = document.createElement("th");
      var cellText = document.createTextNode("Delete Row");
      cell.appendChild(cellText);
      row.appendChild(cell);
      tblBody.appendChild(row);
	  
      // creating all cells
	  for (var i = 0; i < ourData.length; i++) {
	    // creates a table row
	    var row = document.createElement("tr");
	      
	      
	      // Create a <td> element and a text node, make the text
	      // node the contents of the <td>, and put the <td> at
	      // the end of the table row
	      var cell = document.createElement("td");
	      var cellText = document.createTextNode(ourData[i].Title);
	      cell.appendChild(cellText);
	      row.appendChild(cell);
	      var cell = document.createElement("td");
	      var cellText = document.createTextNode(ourData[i].Year);
	      cell.appendChild(cellText);
	      row.appendChild(cell);
	      var cell = document.createElement("td");
	      var cellText = document.createTextNode(ourData[i].imdbID);
	      cell.appendChild(cellText);
	      row.appendChild(cell);
	      var cell = document.createElement("td");
	      var cellText = document.createTextNode(ourData[i].Type);
	      cell.appendChild(cellText);
	      row.appendChild(cell);
	      var cell = document.createElement("td");
	      var cellText = document.createTextNode(ourData[i].Poster);
	      cell.appendChild(cellText);
	      row.appendChild(cell);
	      
	      var cell = document.createElement("td");
	      var button = document.createElement("BUTTON");
	      button.id="b";
	      var t=document.createTextNode("Delete");
	      button.appendChild(t);
	      cell.appendChild(button);
	      row.appendChild(cell);
	      button.setAttribute('onclick','rowDelete(this)');
	    // add the row to the end of the table body
	     tblBody.appendChild(row);
	     //window.onload=function(){(document.getElementById("b")).onclick=function(){var i=this.parentNode.parentNode.rowIndex;
		 //document.getElementById('ta').deleteRow(i);}};
         
	  }
	 
	  // put the <tbody> in the <table>
	  tbl.appendChild(tblBody);
	  // appends <table> into <body>
	  body.appendChild(tbl);
	  // sets the border attribute of tbl to 2;
	  tbl.setAttribute("border", "2");
	}


  function append_table(ourData)
  {
	  var tblBody=document.getElementById("tab");
	  //var swati=document.getElementById("no");
	  window.console.log(ourData);
	  for (var i = 0; i < 10; i++) {
		    // creates a table row
		    var row = document.createElement("tr");
		      
		      
		      // Create a <td> element and a text node, make the text
		      // node the contents of the <td>, and put the <td> at
		      // the end of the table row
		      var cell = document.createElement("td");
		      var cellText = document.createTextNode(ourData[i].Title);
		      cell.appendChild(cellText);
		      row.appendChild(cell);
		      var cell = document.createElement("td");
		      var cellText = document.createTextNode(ourData[i].Year);
		      cell.appendChild(cellText);
		      row.appendChild(cell);
		      var cell = document.createElement("td");
		      var cellText = document.createTextNode(ourData[i].imdbID);
		      cell.appendChild(cellText);
		      row.appendChild(cell);
		      var cell = document.createElement("td");
		      var cellText = document.createTextNode(ourData[i].Type);
		      cell.appendChild(cellText);
		      row.appendChild(cell);
		      var cell = document.createElement("td");
		      var cellText = document.createTextNode(ourData[i].Poster);
		      cell.appendChild(cellText);
		      row.appendChild(cell);
		    
		      var cell = document.createElement("td");
		      var button = document.createElement("BUTTON");
		      var t=document.createTextNode("Delete");
		      button.appendChild(t);
		      cell.appendChild(button);
		      row.appendChild(cell);
		      button.setAttribute('onclick','rowDelete(this)');

		    
		    // add the row to the end of the table body
		    tblBody.appendChild(row);
		  }
		 
  }
  
  function rowDelete(ctl) {
	  var i=ctl.parentNode.parentNode.rowIndex;
	 // window.console.log(this.imdbID);
	  var j=document.getElementById('ta').rows[i].cells[2].innerHTML;
	  //window.console.log(j);
	  document.getElementById('ta').deleteRow(i);
	  del(j);
	}
  function del(j){
	  window.console.log(j);
	  var ourRequest = new XMLHttpRequest();
	  ourRequest.open('GET', 'http://localhost:8080/login/Delete?x='+j);
	  //ourRequest.onload = function() {
	    
	    //	    };
	    ourRequest.send();
	 
	 
  }
