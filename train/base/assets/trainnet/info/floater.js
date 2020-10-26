/**
 * floater
 * 
 * @category    jQuery plugin
 * @license     http://www.opensource.org/licenses/mit-license.html  MIT License
 * @copyright   2010 RaNa design associates, inc.
 * @author      keisuke YAMAMOTO <keisukey@ranadesign.com>
 * @link        http://kaelab.ranadesign.com/
 * @version     1.1.2
 * @date        Jun 10, 2011
 *
 * コンテンツをスクロールに追従させ、ドキュメントの上下に接着させるプラグイン。
 *
 * [オプション]
 * marginTop:     上の余白
 * marginBottom:  下の余白
 * wait:          0～1(初期値 0.5)。0はナビが通り過ぎるまで待つ。1はナビの末端が出るとすぐ動きだす。
 * speed:         アニメーションにかける時間。
 * easing:        イージング
 * fixed:         trueでposition: fixedに切り替え。初期値はfalse。
 *
 */

(function($) {

    $.fn.extend({

        floater: function(options) {
            var config = {
                marginTop: 0,
                marginBottom: 0,
                wait: 0.5,  // 0-1
                speed: 1000,
                easing: "swing",
                fixed: false
            };
            $.extend(config, options);
            config.wait = $(this).outerHeight() - $(window).height() * config.wait;
            config.marginTop = parseInt(config.marginTop, 10) || 0;
            config.marginBottom = parseInt(config.marginBottom, 10) || 0;

            $(this).each(function() {
                var self = $(this);
                var d = $(document).height();
                var h = self.outerHeight() + config.marginTop + config.marginBottom;

                if (config.fixed === true) {
                    self._fixed(config);
                    return true;
                }

                self.css("position", "absolute");

                $(window).scroll(function() {
                    var s = $(window).scrollTop();
                    var w = $(window).height();

                    if (Math.abs(s - self.offset().top) < config.wait) {
                        return;
                    }

                    self.stop(true).animate({
                        top: (d - h) * s / (d - w) + config.marginTop
                    }, {
                        duration: config.speed,
                        easing: config.easing
                    });
                }).scroll();
            });

            return this;
        },
        
        _fixed: function(config) {
            if ($.browser.msie && $.browser.version < 7) {
                $(this).css("position", "absolute");
                this[0].style.cssText = "top: expression(documentElement.scrollTop + " + config.marginTop + " + 'px')";
                document.body.style.background = "url(null) fixed";
            } else {
                $(this).css("position", "fixed").css("top", config.marginTop);
            }
        }
        
    });

})(jQuery);
