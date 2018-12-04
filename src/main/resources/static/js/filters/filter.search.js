app.filter('searchLabel', function() {
    return function(items, keyword) {
      // if no keyword is entered, just display all the items
      if (!keyword) { 
        return items; 
      } 
      else {
    	var newItems = [];
        keyword = keyword.toLowerCase();
        for (var i of items) {
          if (i.label.toLowerCase().indexOf(keyword) > -1) { newItems.push(i); }
        }
        return newItems;
      }
    };
  });

app.filter('searchName', function() {
    return function(items, keyword) {
      // if no keyword is entered, just display all the items
      if (!keyword) { 
        return items; 
      } 
      else {
    	var newItems = [];
        keyword = keyword.toLowerCase();
        for (var i of items) {
          if (i.firstName.toLowerCase().indexOf(keyword) > -1 || 
              i.lastName.toLowerCase().indexOf(keyword) > -1) { newItems.push(i); }
        }
        return newItems;
      }
    };
  });

app.filter('searchManager', function() {
    return function(items, managerKeyword) {
      if (!managerKeyword) { 
        return items; 
      } 
      else {
    	var newItems = [];
        managerKeyword = managerKeyword.toLowerCase();
        for (var i of items) {
        	if(!i.manager){
        		continue;
        	}
          if (i.manager.firstName.toLowerCase().indexOf(managerKeyword) > -1 || 
              i.manager.lastName.toLowerCase().indexOf(managerKeyword) > -1) { newItems.push(i); }
        }
        return newItems;
      }
    };
  });