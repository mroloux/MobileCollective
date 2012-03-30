var credentials = (function() {
	
	function user(){
		if(areUserAndPasswordAvailableInLocalStorage()){
    		return window.localStorage.user;
    	}
        return window.sessionStorage.user;
	}
	
	function pwd(){
		if(areUserAndPasswordAvailableInLocalStorage()){
    		return window.localStorage.pwd;
    	}
        return window.sessionStorage.pwd;
	}
	
	
	function areUserAndPasswordAvailableInLocalStorage(){
		return exists(window.localStorage.user) && exists(window.localStorage.pwd);
	}
	
	function exists(property){
		return property !== null && typeof(property) !== 'undefined';
	}
	
	function encodedUserPassword(){
		return "user="+encodeURIComponent(user())+"&pwd="+encodeURIComponent(pwd());
	}
	
	return {
		encodedUserPassword: encodedUserPassword
	}
})();