import logo from './logo.svg';
import '../src/styles/variables/main.scss';
import SearchBar from './components/SearchBar/SearchBar';
import Usernames from './components/Usernames/Usernames';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
          <SearchBar />
          <Usernames />
        </p>
        <h1>Test</h1>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
