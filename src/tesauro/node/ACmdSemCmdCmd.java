/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class ACmdSemCmdCmd extends PCmd
{
    private PCmdSemCmd _cmdSemCmd_;

    public ACmdSemCmdCmd()
    {
        // Constructor
    }

    public ACmdSemCmdCmd(
        @SuppressWarnings("hiding") PCmdSemCmd _cmdSemCmd_)
    {
        // Constructor
        setCmdSemCmd(_cmdSemCmd_);

    }

    @Override
    public Object clone()
    {
        return new ACmdSemCmdCmd(
            cloneNode(this._cmdSemCmd_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACmdSemCmdCmd(this);
    }

    public PCmdSemCmd getCmdSemCmd()
    {
        return this._cmdSemCmd_;
    }

    public void setCmdSemCmd(PCmdSemCmd node)
    {
        if(this._cmdSemCmd_ != null)
        {
            this._cmdSemCmd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cmdSemCmd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._cmdSemCmd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._cmdSemCmd_ == child)
        {
            this._cmdSemCmd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._cmdSemCmd_ == oldChild)
        {
            setCmdSemCmd((PCmdSemCmd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
