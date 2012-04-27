<head>
    <title>#{get 'title' /}</title>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta charset="${_response_encoding}">
    <link rel="stylesheet" media="screen" href="@{'/public/stylesheets/main.css'}">
    #{get 'moreStyles' /}
    <link rel="shortcut icon" type="image/png" href="@{'/public/images/favicon.png'}">
    <script src="@{'/public/javascripts/collective.js'}" type="text/javascript" charset="${_response_encoding}"></script>
    
    <link rel="stylesheet" href="@{'/public/stylesheets/themes/mobileCollective.min.css'}" />
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile.structure-1.1.0.min.css" />
	
	<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
    #{get 'moreScripts' /}
    <script type="text/javascript">
        $.mobile.defaultPageTransition = 'none';
    </script>
</head>