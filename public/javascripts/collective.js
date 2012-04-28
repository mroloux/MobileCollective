var credentials = (function() {
    var storage;

	function user(){
        return storage.user;
	}
	
	function pwd(){
        return storage.pwd;
	}

	function urlSafeUserPassword(){
		return "user="+encodeURIComponent(user())+"&pwd="+encodeURIComponent(pwd());
	}
	
	function logout(){
        storage.clear();
	}

    function logIn(user, pwd, local){
        if (local){
            storage = window.localStorage;
        } else {
            storage = window.sessionStorage;
        }
        storage.user = user;
        storage.pwd = pwd;
    }

    function isLoggedIn() {
        return (storage !== null && typeof(storage) !== 'undefined');
    }

    function init(){
        if(credentialsInSessionStorage()) {
            storage = window.sessionStorage;
        } else if (credentialsInLocalStorage()) {
            storage = window.localStorage;
        }
    }

    function credentialsInSessionStorage() {
        return (window.sessionStorage.user !== null && typeof(window.sessionStorage.user) !== 'undefined') &&
               (window.sessionStorage.pwd !== null && typeof(window.sessionStorage.pwd) !== 'undefined');
    }

    function credentialsInLocalStorage() {
        return (window.localStorage.user !== null && typeof(window.localStorage.user) !== 'undefined') &&
               (window.localStorage.pwd !== null && typeof(window.localStorage.pwd) !== 'undefined');
    }

    init();

	return {
	    logIn: logIn,
	    isLoggedIn: isLoggedIn,
		urlSafeUserPassword: urlSafeUserPassword,
		logout: logout,
		user: user,
		password: pwd
	}
})();