(() => {
    const scrollButton = document.body.querySelector('#scroll-top');
    const header       = document.querySelector('.article-header');

    const STATE_SHOWN  = 'shown';
    const STATE_HIDDEN = 'hidden';

    const allowHeaderStateChange = () => {
        window.addEventListener('click', toggleHeaderState);
    };

    const disableHeaderStateChange = () => {
        window.removeEventListener('click', toggleHeaderState);
    };

    const toggleHeaderState = () => {
        header.dataset.state = 
            (header.dataset.state === STATE_HIDDEN) 
                ? STATE_SHOWN 
                : STATE_HIDDEN;
    };

    window.addEventListener('scroll', () => {
        if (window.scrollY >= 40) {
            header.dataset.state = STATE_HIDDEN;
            allowHeaderStateChange();
        } else {
            header.dataset.state = STATE_SHOWN;
            disableHeaderStateChange();
        }
        scrollButton.dataset.state = 
            (window.scrollY <= 799) 
                ? STATE_HIDDEN 
                : STATE_SHOWN;
    });
})();
