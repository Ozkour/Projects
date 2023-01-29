const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require('copy-webpack-plugin');

module.exports = {
  entry: path.resolve(__dirname, './src/scripts/pong.js'),

  mode : 'development',

  output: {
    path: path.resolve(__dirname, '../server/public'),
    filename: 'scripts/bundle.js'
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: "./src/index.html",
      filename: "./index.html"
        }),
    new CopyPlugin({
      patterns: [
	{
	  from: 'src/style/*',
	  to:   'style/[name][ext]'
	},
  {
	  from: 'src/images/*',
	  to:   'images/[name][ext]'
	}
      ]
   })
  ],
  module: {
    rules : [
      {
        test: /\.(png|jpg|gif)/i,
        use: [
          {
            loader: 'file-loader',
            options: {
              name : '[name].[ext]',
              outputPath : 'images'
            }
          }
        ]
      }
    ]
  },
  devServer: {
    static: {
       publicPath: path.resolve(__dirname, 'dist'),
       watch : true
    },
    host: 'localhost',
    port : 8888,
    open : true
},
};
