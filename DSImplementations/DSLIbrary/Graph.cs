using System;
using System.Collections.Generic;
using System.Text;

namespace Files
{
    public class GraphNode
    {
        public int data;
        public List<GraphNode> children;

        public GraphNode(int data)
        {
            this.data = data;
            children = new List<GraphNode>();
        }
    }

    public class GraphNodeString
    {
        public string data;
        public List<GraphNodeString> children;

        public GraphNodeString(string data)
        {
            this.data = data;
            children = new List<GraphNodeString>();
        }
    }

    public class TreeHierarchy
    {
        public List<GraphNodeString> graphNodes;

        public TreeHierarchy()
        {
            this.graphNodes = new List<GraphNodeString>();
        }

        public void ConstructGraph(string[] nodeData)
        {
            int pointer = 0;
            while(pointer < nodeData.Length - 1)
            {
                if(string.Compare(nodeData[pointer], nodeData[pointer + 1]) == 0)
                {
                    this.graphNodes.Add(new GraphNodeString(nodeData[pointer]));
                    pointer += 2;
                }
                else
                {
                    this.graphNodes.Add(GetChildrenRecursive(nodeData,ref pointer));
                    pointer += 1;
                }
            }

        }

        private GraphNodeString GetChildrenRecursive(string[] nodeData,ref int index)
        {
            var currentNode = new GraphNodeString(nodeData[index]);
            int localIndex = index;
            int returnIndex = index + 1;
            while (string.Compare(nodeData[localIndex], nodeData[returnIndex]) != 0)
            {
                index += 1;
                currentNode.children.Add(GetChildrenRecursive(nodeData, ref index));
                returnIndex = index+1;
            }
            index += 1;
            return currentNode;

        }
            
            
            
        


    }


    public class GraphNodeU
    {
        public int data;
        public List<GraphNodeU> children;

        public GraphNodeU(int data)
        {
            this.data = data;
            children = new List<GraphNodeU>();
        }
    }
    
}
