AUI().ready(
    /*
    	This callback function gets loaded when all the HTML, 
    	not including the any AJAX content, is loaded.
    */
    function() { 
    	
    	console.log("Portlet HTML is now loaded.");

    	Liferay.Loader.require('tippy', function(tippy) {
    		tippy('.gradebook-tip', {
    			hideOnClick: false
    		}); 
    	});
    }
);

Liferay.Portlet.ready(

    /* 
    	This callback function gets loaded after each and every portlet on the page.
	
    	portletId: the current portlet's id
    	node: the Alloy Node object of the current portlet
    */
    function(portletId, node) {
    	console.log("Portlet is now loaded.");
    }
);
