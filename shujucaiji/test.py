# -*- coding: utf-8 -*-  
class Node(object):
    def __init__(self, data = None, child = []):
        self.data = data
        self.child = child
        
class MyTree(object):
    def __init__(self):
        self.root = Node()
        
    
    def add(self, data):
        node = Node(data)
        #print data[0:-2]
        parent = self.find_node(self.root, data[0:-2])
        if parent != -1:
            parent.child.append(node)
        
    def find_node(self, node, data):
        if len(data) == 0 or node.data == data:
            return node
        for n in self.child:
            if data.find(n.data) == 0:
                break
        if data.find(n.data) == 0:
            return self.find_node(n, data)
        else:
            return -1
        
if __name__ == '__main__':
    a = ["啊", "阿", "埃", "阿根", "阿胶", "阿拉", "埃及", "阿根廷", "阿拉伯", "阿拉伯人"]
    tree = MyTree()
    
    #for data in a:
        #print data
    tree.add(u"啊")
    tree.add(u"阿")
    tree.add(u"埃")
    tree.add(u"阿根")
    print tree.root.child[0].data
    print tree.root.child[1].data
    print tree.root.child[1].child[0].data
    print tree.root.child[2].data
    
        
            