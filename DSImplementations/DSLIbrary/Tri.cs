using System;
using System.Collections.Generic;
using System.Text;

namespace Files
{
    public class TriNode
    {
        public Dictionary<char, TriNode> _data;
        public bool _isEndOFWord;

        public TriNode()
        {
            _data = new Dictionary<char, TriNode>();
            _isEndOFWord = false;
        }
    }

    public class Tri
    {
        public TriNode content;

        public Tri()
        {
            content = new TriNode();
        }

        public void InsertWord(string words)
        {

            foreach(var word in words.Split(' '))
            {
                var tempIterator = content;

                foreach (var car in word)
                {
                    if (!tempIterator._data.ContainsKey(car))
                    {
                        tempIterator._data.Add(car, new TriNode());
                    }
                    tempIterator = tempIterator._data[car];
                }
                tempIterator._isEndOFWord = true;
            }
        }

        public bool Search(string word)
        {
            var tempIterator = content;

            foreach (var car in word)
            {
                if (!tempIterator._data.ContainsKey(car))
                {
                    return false;
                }
                tempIterator = tempIterator._data[car];
            }
            return tempIterator._isEndOFWord;
        }


        public List<string> PrefixSearch(string word)
        {
            List<string> result = new List<string>();
            bool foundPrefix = true;
            var tempIterator = content;

            foreach (var car in word)
            {
                if (!tempIterator._data.ContainsKey(car))
                {
                    foundPrefix = false;
                    break;
                }
                tempIterator = tempIterator._data[car];
            }

            if (foundPrefix)
                PrefixSearchHelper(word, tempIterator, result);

            return result;
        }


        private void PrefixSearchHelper(string inp,TriNode node,List<string> result)
        {
            if (node._isEndOFWord)
                result.Add(inp);
            foreach(var item in node._data)
            {
                PrefixSearchHelper(inp + Convert.ToString(item.Key), item.Value , result);
            }
        }


        public bool Delete(string word)
        {
            return DeleteWord(word, 0, this.content);
        }


        private bool DeleteWord(string word, int position, TriNode node)
        {
            if (position == word.Length)
            {
                if (node._isEndOFWord == true)
                {
                    node._isEndOFWord = false;

                    if (node._data.Count == 0)
                        return true;
                    else
                        return false;
                }
            }
            if (node._data.ContainsKey(word[position]))
            {
                var result = DeleteWord(word, position + 1, node._data[word[position]]);
                if (result && node._data.Count == 1)
                {
                    node._data.Remove(word[position]);
                    return true;
                }
            }
            return false;
        }







    }
}
