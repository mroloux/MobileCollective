function loadList() {
    $.mobile.showPageLoadingMsg();

    $.ajax({
        url: '/SocialText/signals?'+credentials.urlSafeUserPassword(),
        success: function(data) {
            var list = $("<ul data-role='listview' id='signals'>");
            for(var i = 0; i < data.length; ++i) {
                var signal = data[i];
                $.mobile.hidePageLoadingMsg();

                // Make conversation div
                var conversationDiv = createSignalDiv(signal);
                conversationDiv.appendTo(list);
            }
            list.appendTo(".ui-page");
            $(".ui-page").trigger("create");
        },
        error: function(jqXHR) {
            if(jqXHR.status == 403) {
            window.location = "/";
            }
        }
    });
}

function createSignalDiv(signal) {
    // Make Photo div
    var photoDiv = $("<img />",{src: '/SocialText/photo?' + credentials.urlSafeUserPassword() +
                '&userId='+ signal.user_id});

    // Make content - author - timestamp divs
    var contentDiv = '<p class="content">'+ signal.body +'</p>';
    var authorDiv = '<p class="author">Author: ' + signal.best_full_name + '</p>';
    var timestampDiv = '<p class="timestamp">'+ configureTimestamp(signal.at) +'</p>';

    // Make data div
    var dataDiv = $('<a href="#"/>').append(contentDiv).append(authorDiv).append(timestampDiv);

    // Make signal div
    var signalDiv = $('<li/>').append(photoDiv).append(dataDiv);



    return signalDiv;
}

function getSignal(signalId, signalDiv) {
    $.ajax({
        url: '/SocialText/signal?signalId=' + signalId + '&' + credentials.encodedUserPassword(),
        success: function(data) {
            signalDiv.before(createSignalDiv(data));
        }
    });

    $.ajax({
        url: '/SocialText/replies?signalId=' + signalId + '&' + credentials.encodedUserPassword(),
        success: function(data) {
            for(var i = data.length-1; i >= 0; --i) {
                var signal = data[i];
                $.mobile.hidePageLoadingMsg();
                signalDiv.before(createSignalDiv(signal));
            }
        }
    });
}

function configureTimestamp(timestamp) {
    var result = "gepost op ";

    result += timestamp.substring(0, 9);
    result += " om ";
    result += timestamp.substring(11,16);

    return result;
}

function isInReplyTo(signal) {
    return signal.in_reply_to;
}