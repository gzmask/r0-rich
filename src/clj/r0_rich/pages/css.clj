(ns r0_rich.pages.css)

(defn css [] 
  {:headers {"Content-Type" "text/css"}
   :body "body {
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 10px 50px;
            background-size: 1280px 800px;
            color: #FFFFFF;
            font-family: advent-Bd1;}
          div.content {
            font-size: 20px;}
          div.top_bar {
            height: 4px;
            width: 16%;
            float: left;}
          #navi_bar {
            background-image: url('/img/richever_logo.png');
            background-color: #1A1E24;
            background-repeat: no-repeat;
            background-position: 615px 150px;
            padding: 50px 0px 20px 0px;
            height: 70px;
            transition: background-color 500ms ease,height 1500ms ease;}
          #navi_bar:hover {
            background-color: #000;
            height: 200px;
          }
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
            transition: color 1s ease,font-size 200ms ease;}
          .nav_bn:hover {
            font-size: 25px;
            color:#F5F5F5;}
          .circle { 
            width: 140px;
            height: 240px;
            padding: 8px 70px 8px 70px;
            font-size: 25px;
            background: #AEB6BD; 
            background-image: url('/img/richever_logo.png');
            background-position: -150px 0px;
            background-repeat: no-repeat;
            -moz-border-radius: 70px; 
            -webkit-border-radius: 70px; 
            border-radius: 70px;
            padding-top: 239px;
            transition: padding-top 1s ease, background-position 1s ease;}
          .circle:hover {
            padding-top: 95px;
            background-position: 0px 0px;
          }
          #loading {
            padding: 150px 0 0 615px;
            background: black;
            width: 100%;
            overflow:hidden;
            position: absolute;
            z-index: 10;
            height: 100%;
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
            -webkit-animation: rotation 2s infinite linear;
          }
          a:link {color:#6C7381;}
          a:visited {color:#6C7381; }
          a:hover {text-decoration: none;}
          a:active {color:#6C7381;}
          "})

