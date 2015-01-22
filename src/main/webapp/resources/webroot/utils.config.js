utils.config.set({
	debug : true,
	contextPath : 'app',
	resourcePath : 'resources',
	dataPath : 'data',
	bundle_list : "/app/resources/resources.json?cb=utils.updateBundle&$=*&",
	moduleDir : {
		'test.*' : 'test/'
	},
	template : 'folader',
	combine : true,
	TAG_ATTR : {
		DATA_PATH : 'rx-path',
		DATA_ONCHANGE : 'rx-onchange',
		DATA_ONCLICK : 'rx-click',
		DATA_FORMAT : 'data-format'
	}
});