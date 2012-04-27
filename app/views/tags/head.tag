<head>
    <title>#{get 'title' /}</title>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta charset="${_response_encoding}">
    <link rel="stylesheet" media="screen" href="@{'/public/stylesheets/main.css'}">
    <link rel="stylesheet" media="screen" href="@{'/public/stylesheets/jquery.mobile-1.0.1.min.css'}">
    <link rel="stylesheet" media="screen" href="@{'/public/stylesheets/jquery.mobile.structure-1.0.1.min.css'}">
    #{get 'moreStyles' /}
    <link rel="shortcut icon" type="image/png" href="@{'/public/images/favicon.png'}">

    <script src="@{'/public/javascripts/jquery-1.6.4.min.js'}" type="text/javascript" charset="${_response_encoding}"></script>
    <script src="@{'/public/javascripts/jquery.mobile-1.0.1.min.js'}" type="text/javascript" charset="${_response_encoding}"></script>
    <script src="@{'/public/javascripts/collective.js'}" type="text/javascript" charset="${_response_encoding}"></script>
    <script src="@{'/public/javascripts/listview.js'}" type="text/javascript" charset="${_response_encoding}"></script>
    #{get 'moreScripts' /}
    <script type="text/javascript">
        $.mobile.defaultPageTransition = 'none';
    </script>
</head>