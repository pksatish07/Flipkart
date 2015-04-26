//uses classList, setAttribute, and querySelectorAll
//if you want this to work in IE8/9 youll need to polyfill these
(function(){
	

	
	var d = document,
	accordionToggles = d.querySelectorAll('.js-accordionTrigger'),
	setAria,
	setAccordionAria,
	switchAccordion,
  touchSupported = ('ontouchstart' in window),
  pointerSupported = ('pointerdown' in window);
  
  skipClickDelay = function(e){
    e.preventDefault();
    e.target.click();
  };

		setAriaAttr = function(el, ariaType, newProperty){
		el.setAttribute(ariaType, newProperty);
	};
	setAccordionAria = function(el1, el2, expanded){
	
		switch(expanded) {
      case "true":
      	setAriaAttr(el1, 'aria-expanded', 'true');
      	setAriaAttr(el2, 'aria-hidden', 'false');
      	break;
      case "false":
      	setAriaAttr(el1, 'aria-expanded', 'false');
      	setAriaAttr(el2, 'aria-hidden', 'true');
      	break;
      default:
				break;
		}
	};

//function
switchAccordion = function(e) {
	
	
	e.preventDefault();
	

	
	if(e.target.id=="rajeev03")
		{
		var thisAnswer1=document.getElementById("accordion1");
		var thisAnswer2=document.getElementById("newuser");
			thisAnswer2.classList.toggle('is-collapsed');
			thisAnswer1.setAttribute('class','accordionItem is-collapsed');
		}
	else if(e.target.id=="afterpwdset")
	{
	var thisAnswer1=document.getElementById("accordion2");
	var thisAnswer2=document.getElementById("newuser");
	if(thisAnswer1.classList.contains('is-collapsed'))
		{
		thisAnswer1.classList.toggle('is-collapsed');
		}
		thisAnswer2.classList.toggle('is-collapsed');
		
 	
	}
	else if(e.target.id=="deliverhere1")
	{
		accordionToggles[6].addEventListener('click', switchAccordion, true);
		
	document.getElementById("selected1").style.visibility="visible";
	document.getElementById("selected2").style.visibility="hidden";
	document.getElementById("selected3").style.visibility="hidden";
	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer3=document.getElementById("accordion3");
	thisAnswer3.classList.toggle('is-collapsed');
	
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
 	
	}
	
	else if(e.target.id=="deliverhere2")
	{
		accordionToggles[6].addEventListener('click', switchAccordion, true);
		
	document.getElementById("selected2").style.visibility="visible";
	document.getElementById("selected1").style.visibility="hidden";
	document.getElementById("selected3").style.visibility="hidden";
	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer3=document.getElementById("accordion3");
	thisAnswer3.classList.toggle('is-collapsed');
	
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
 	
	}
	else if(e.target.id=="topayment")
	{
		accordionToggles[8].addEventListener('click', switchAccordion, true);
		var thisAnswer1=document.getElementById("accordion1");
		var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer3=document.getElementById("accordion3");
	var thisAnswer4=document.getElementById("accordion4");
	thisAnswer4.classList.toggle('is-collapsed');
	
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
	thisAnswer3.setAttribute('class','accordionItem is-collapsed');
	thisAnswer1.setAttribute('class','accordionItem is-collapsed');
	
 	
	}
	
	else if(e.target.id=="deliverhere3")
	{
		accordionToggles[6].addEventListener('click', switchAccordion, true);
	document.getElementById("selected3").style.visibility="visible";
	document.getElementById("selected2").style.visibility="hidden";
	document.getElementById("selected1").style.visibility="hidden";
	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer3=document.getElementById("accordion3");
	thisAnswer3.classList.toggle('is-collapsed');
	
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
 	
	}
	
	
	else if(e.target.id=="change")
	{
	var thisAnswer1=document.getElementById("accordion1");
	var thisAnswer2=document.getElementById("existinguser");
	thisAnswer1.classList.toggle('is-collapsed');
	
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
 	
	}
	else if(e.target.id=="papa1")
		{

		var thisAnswer2=document.getElementById("accordion2");
		var thisAnswer1=document.getElementById("accordion1");
		var thisAnswer3=document.getElementById("accordion3");
		var thisAnswer4=document.getElementById("accordion4");
		var thisAnswer5=document.getElementById("existinguser");
		var thisAnswer6=document.getElementById("newuser");
		thisAnswer1.classList.toggle('is-collapsed');
		
		thisAnswer2.setAttribute('class','accordionItem is-collapsed');
		thisAnswer3.setAttribute('class','accordionItem is-collapsed');
		thisAnswer4.setAttribute('class','accordionItem is-collapsed');
		thisAnswer5.setAttribute('class','accordionItem is-collapsed');
		thisAnswer6.setAttribute('class','accordionItem is-collapsed');
		
		}
	else if(e.target.id=="papa2")
	{

	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer1=document.getElementById("accordion1");
	var thisAnswer3=document.getElementById("accordion3");
	var thisAnswer4=document.getElementById("accordion4");
	thisAnswer2.classList.toggle('is-collapsed');
	
	thisAnswer1.setAttribute('class','accordionItem is-collapsed');
	thisAnswer3.setAttribute('class','accordionItem is-collapsed');
	thisAnswer4.setAttribute('class','accordionItem is-collapsed');
	
	}
	else if(e.target.id=="papa3")
	{

	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer1=document.getElementById("accordion1");
	var thisAnswer3=document.getElementById("accordion3");
	var thisAnswer4=document.getElementById("accordion4");
	thisAnswer3.classList.toggle('is-collapsed');
	
	thisAnswer1.setAttribute('class','accordionItem is-collapsed');
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
	thisAnswer4.setAttribute('class','accordionItem is-collapsed');
	
	}
	else if(e.target.id=="papa4")
	{
		
	var thisAnswer2=document.getElementById("accordion2");
	var thisAnswer1=document.getElementById("accordion1");
	var thisAnswer3=document.getElementById("accordion3");
	var thisAnswer4=document.getElementById("accordion4");
	thisAnswer4.classList.toggle('is-collapsed');
	
	thisAnswer1.setAttribute('class','accordionItem is-collapsed');
	thisAnswer2.setAttribute('class','accordionItem is-collapsed');
	thisAnswer3.setAttribute('class','accordionItem is-collapsed');
	
	}
	else
		{
		window.alert(e.target.id);
	var thisAnswer = e.target.parentNode.nextElementSibling;
	
	var thisQuestion = e.target;
	//document.getElementById('accordion2').setAttribute('aria-hidden', 'false');
	
	if(thisAnswer.classList.contains('is-collapsed')) {
		setAccordionAria(thisQuestion, thisAnswer, 'true');
	} else {
		setAccordionAria(thisQuestion, thisAnswer, 'false');
	}
  	thisQuestion.classList.toggle('is-collapsed');
  	thisQuestion.classList.toggle('is-expanded');
		thisAnswer.classList.toggle('is-collapsed');
 	
		}
	};
	
	switchAccordion1 = function(e) {
		
		var thisQuestion = e.target;
	
		//thisQuestion.setAttribute('aria-expanded', 'true');
		alert(e.target.id);
		
		var thisAnswer= document.getElementById("accordion1");
		
		setAccordionAria(thisQuestion, thisAnswer, 'true');
			thisAnswer.classList.toggle('is-collapsed');
		};
		
	for (var i=0,len=accordionToggles.length; i<len; i++) {
		
		
		if(touchSupported) {
      accordionToggles[i].addEventListener('touchstart', skipClickDelay, true);
    }
    if(pointerSupported){
      accordionToggles[i].addEventListener('pointerdown', skipClickDelay, true);
    }
    // 6:cart accordion 8:payment accordion i!=6 ||
if( i!=8)
	accordionToggles[i].addEventListener('click', switchAccordion, true);
  }
})();