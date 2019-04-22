Ext.define('CustomApp', {
    extend: 'Rally.app.App',
    componentCls: 'app',
    items: [
        {
            xtype: 'container',
            itemId: 'exportButton'
        }],
    
    launch: function() {
    	 this._loadMilestones();       	 
    	 console.log("Inside 'Launch");
    },

    //load the initial data of custom app
    _loadMilestones: function() {
    	console.log("Inside 'Milestone");
    	this.milestoneComboBox = Ext.create('Rally.ui.combobox.MilestoneComboBox',{   		
    		fieldLabel: 'Milestone',
    		hideLabel: false,
    		labelAlign: 'right',
    		listeners: {
    			ready: function(combobox) {
    				this._loadData();
    			},
    				
       			select: function(combobox, records) {
    				this._loadData();
    			},   
    			scope: this
    		}
        });
    	this.add(this.milestoneComboBox);
    },
    
    //Get defects data from rally based on filters
    _loadData: function() {
    	console.log("Inside Load");
    	var selectedMilestone = this.milestoneComboBox.getRecord().get('_ref');
    	var defectfilters = [
    	    {
    	      property: 'Milestones',
    	      operator: '=',
    	      value: selectedMilestone
            },
           {
          	  property: 'AffectsDoc',
          	  operator: '=',
          	  value: 'true'
           },
           {
        	   property: 'State',
        	   operator: '!=',
        	   value: 'Fixed'
           },
           {
         	  property: 'State',
         	  operator: '!=',
         	  value: 'Closed'
           }
        ];
      
    	if(this.defectStore){
    		this.defectStore.setFilter(defectfilters);
    		this.defectStore.load();
    	}
    	else {
    	this.defectStore =  Ext.create('Rally.data.wsapi.Store', {
    	model: 'Defect',
    	autoLoad: true,
        filters: defectfilters,
    	listeners: {
    	        load: function(mystore, mydata, success) {
    	        if(!this.myGrid) {
    	        this._createGrid(mystore);
    	        }
    	        },
    		    scope:this
    	},
    	fetch: ['FormattedID', 'Name', 'Description', 'State', 'AffectsDoc']
    	});
    	console.log("Store Data :",this.defectStore);
    	}
    	
    },
    
    //Show the data fetched in a grid
    _createGrid: function(myDefectStore) {
    	console.log("Inside 'Grid");
    	this.myGrid = Ext.create('Rally.ui.grid.Grid', {
      		store: myDefectStore,
      		columnCfgs: [
      			'FormattedID', 'Name', 'Description', 'State', 'AffectsDoc'	
      		]
        });
     console.log('my grid', this.myGrid); 
     this.add(this.myGrid);
     var exportToExcel = {
	            xtype: 'rallybutton',
	            rtl: true,
	            iconCls: 'icon-export',
	            toolTip:'Export to Excel',
	            menu: [{text: 'Send to Doc',
	            	handler: function() {
	            		this._callConfluence(myDefectStore)
	            	},
	            	scope: this
	            	}
	            	],	           
	            layout: {
	                type: 'hbox',
	                align: 'right'
	            },
	            style: {
	                float: 'right'
	            },
	            scope: this           
	        };
	        this.down('#exportButton').add(exportToExcel);
    }, 
    
    //Call to the confluence to post an article
    _callConfluence: function(store) {
    	console.log("Inside Call Confluence");
        var  items = store.data.items;
        var result = "<table>";
        result += "<thead><th><td>Issue Title</td><td>Issue Description</td></th></thead><tbody>";
        for(var i=0; i<items.length; i++) {
          result += "<tr><td>" + this._html2text(items[i].data.Name) + "</td><td>" + this._html2text(items[i].data.Description) + "</td></tr>";
        }
        result += "</tbody></table>";
        console.log(result.replace(/\s/g, ' '));
    },
    
   // Strip html from string
    _html2text: function(html) {
      var tag = document.createElement('div');
      tag.innerHTML = html;
      return tag.innerText;
    },

}); 