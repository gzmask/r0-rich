(ns r0_rich.pages.css)

(defn css []
  {:headers {"Content-Type" "text/css"}
   :body "body {
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 10px 50px;
            background-size: 1280px 800px;
            color: #FFFFFF;
            font-size: 20px;
            font-family: advent-Bd1;}
          div.content {
            font-size: 20px;}
          div.top_bar {
            height: 4px;
            width: 16%;
            float: left;}
          div.newshead {
            padding: 8px 0px 0px 5px;
            color: #000;
            background-color: #ccc;
            border-radius: 5px;
          }
          div.newsbody {
            padding: 15px 0px 15px 15px;
            border-radius: 8px;
            background-color: #000;
          }
          #navi_bar {
            background-image: url('/img/richever_logo.png');
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 615px 150px;
            padding: 50px 0px 20px 0px;
            height: 70px;
            -webkit-transition: background-color 500ms ease,height 1500ms ease;
            transition: background-color 500ms ease,height 1500ms ease;}
          #navi_bar:hover {
            background-color: #000;
            height: 200px; }
          @font-face {
            font-family: advent-Re;
            src: url('fonts/advent-Re.otf');}
          @font-face {
            font-family: advent-Lt1;
            src: url('fonts/advent-Lt1.otf');}
          @font-face {
            font-family: advent-Bd1;
            src: url('fonts/advent-Bd1.otf');}
          hr {
            border: 0;
            height: 1px;
            background: #555;
            background: -webkit-gradient(linear, 0 0, 100% 0, from(#1A1E24), to(#1A1E24), color-stop(50%, #555));}
          .nav_bn {
            color:#6C7381;
            font-size: 22px;
            font-family: advent-Re;
            -webkit-transition: color 1s ease,font-size 200ms ease;
            transition: color 1s ease,font-size 200ms ease;}
          .nav_bn:hover {
            font-size: 28px;
            color:#FFF;}
          .circle {
            width: 140px;
            height: 240px;
            padding: 8px 70px 8px 70px;
            font-size: 25px;
            -moz-border-radius: 70px;
            -webkit-border-radius: 70px;
            border-radius: 70px;}
          .icon1 {
            opacity: 0.0;
            background: #90dd1f;
            background-image: url('/img/design_icon.png');
            background-repeat: no-repeat;
            background-position: 80px 0px;
            padding-top: 95px;
            -webkit-transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;
            transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;}
          .icon2 {
            opacity: 0.0;
            background: #1a34a4;
            background-image: url('/img/store_icon.png');
            background-repeat: no-repeat;
            background-position: 80px 0px;
            padding-top: 95px;
            -webkit-transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;
            transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;}
          .icon3 {
            opacity: 0.0;
            background: #fce700;
            background-image: url('/img/service_icon.png');
            background-repeat: no-repeat;
            background-position: 80px 0px;
            padding-top: 95px;
            -webkit-transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;
            transition: opacity 1s ease, padding-top 1s ease, background-position 2s ease 1s;}
          .icon1:hover, .icon2:hover, .icon3:hover {
            opacity: 1.0;
            padding-top: 259px;
            background-position: -350px 0px;
          }
          #loading {
            padding: 150px 0 0 615px;
            background: black;
            width: 100%;
            overflow:hidden;
            position: absolute;
            z-index: 10;
            height: 100%;
            -webkit-transition: opacity 2s ease, visibility 0s linear 2s;
            transition: opacity 2s ease, visibility 0s linear 2s;
          }
          @-webkit-keyframes rotation {
            from {-webkit-transform: rotate(0deg);}
            to {-webkit-transform: rotate(360deg);}
          }
          @keyframes rotation {
            from {-webkit-transform: rotate(0deg);}
            to {-webkit-transform: rotate(360deg);}
          }
          #rotation_logo {
            -webkit-animation: rotation 2s infinite linear;}
          a.icon:link {opacity: 1.0; background-color: #1A1E24; padding: 5px; color:#888;}
          a.icon:visited {opacity: 1.0; color:#888; }
          a.icon:hover {opacity: 1.0; color:#fff; text-decoration: none;}
          a.icon:active {opacity: 1.0; color:#fff;}
          a.nav_bn:link {color:#6C7381;}
          a.nav_bn:visited {color:#6C7381; }
          a.nav_bn:hover {text-decoration: none;color:#FFF; }
          a.nav_bn:active {color:#6C7381;}
          "})

