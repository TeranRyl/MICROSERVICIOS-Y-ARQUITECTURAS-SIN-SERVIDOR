var app = (function () {
    return {
        renderTweet: function (tweet) {
            const tweetsContainer = document.getElementById("tweets");
            const tweetElement = document.createElement('div');
            tweetElement.className = 'tweet-container';
            tweetElement.innerHTML = `
                <img class="tweet-image" src="./logo.jpg" alt="Avatar">
                <div class="tweet-text">${tweet.message}</div>
            `;
            tweetsContainer.appendChild(tweetElement);
        },

        getTweets: async function () {
            const options = {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            try {
                const response = await fetch("http://localhost:8080/posts", options);
                if (response.ok) {
                    const jsonResponse = await response.json();
                    jsonResponse.forEach(tweet => this.renderTweet(tweet));
                } else {
                    const errorReason = await response.json();
                    return errorReason;
                }
            } catch (error) {
                console.error('Error fetching tweets:', error);
            }
        },

        createTweet: async function () {
            const usuario = document.getElementById("user").value;
            const mensaje = document.querySelector('textarea[name="message"]').value;
            const tweet = {
                message: mensaje,
                user: usuario
            };

            const options = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(tweet)
            };

            try {
                const response = await fetch("http://localhost:8080/posts", options);
                if (response.ok) {
                    location.reload();
                } else {
                    const errorReason = await response.json();
                    console.error('Error creating tweet:', errorReason);
                }
            } catch (error) {
                console.error('Error creating tweet:', error);
            }
        }

       
    };
})();
