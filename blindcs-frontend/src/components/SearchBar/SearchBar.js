import React, { Component } from 'react'
import axios from 'axios'

export default class SearchBar extends Component {
  constructor() {
    super()
    this.state = { value: "" };
  }

  _handleKeyDown = (e) => {
    // TODO: Update requests to correct endpoints
    if (e.key === "Enter") {
      axios
        .get('http://localhost:8080/api/v1/account', {
          searchText: e.target.value
        })
        .then(({ data }) => {
          console.log(data);
        });
    }
  }

  _handleChange = (e) => {
    this.setState({ value: e.target.value });
  }

  render() {
    return (
      <div className="search">
        <input type="text" placeholder="Search"
          onKeyDown={this._handleKeyDown}
          onChange={this._handleChange}
        />
      </div>
    );
  }
}
